package com.tiempo

import com.dto.wwo.Root
import com.google.gson.Gson
import com.tiempo.wwo.WeatherForecast
import grails.transaction.Transactional
import org.apache.log4j.Logger

/**
 * Created by yaskalv on 10.06.2015.
 */
class ImportService {

    static transactional = false

    private static final log = Logger.getLogger(ImportService.class)

    def essentialConverterService
    def importUrlProvider

    def runForecastImport() {
        City.findAllByIsWeatherImported(true).each {
//        City it = City.findByIsWeatherImported(true)
            log.info("Starting import for the city ${it.printName}")
            WeatherForecast forecast = WeatherForecast.findByCity(it)
            if (!forecast) {
                log.info("Have not found forecast for ${it.printName}. Will be creating new")
                forecast = new WeatherForecast(city: it)
                forecast.save()
            }
            long start = System.currentTimeMillis()
            performCityForecast(forecast)
            if (System.currentTimeMillis() - start < 200) {
                log.warn("ATTENTION! The time spent to ${it.printName} is ${System.currentTimeMillis() - start} millisends. Consider wait a bit to avoid exceed the limit of 5 request per second set up by API provider")
            }
            log.info("Time per forecast item: ${}")
            log.info("End import for the city ${it.printName}")
        }
    }

    @Transactional
    def performCityForecast(WeatherForecast forecast) {
        String url = prepareUrl(forecast)
        String content = url.toURL().getText("UTF-8")
        Root root = new Gson().fromJson(content, Root.class)
        essentialConverterService.refillForecast(forecast, root.data)
        forecast.save(failOnError: true)
    }

    private String prepareUrl(WeatherForecast forecast) {
        String url = importUrlProvider.provideUrlBase()
        String locStr = "&q=${forecast.city.lat}".replaceAll(",", ".") + "," + "${forecast.city.lon}".replaceAll(",", ".")
        url + locStr
    }
}
