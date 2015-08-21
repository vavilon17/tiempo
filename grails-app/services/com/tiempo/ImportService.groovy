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

    static final API_KEY = "ffde3b758c4d6b6747cab9780cbff"

    def essentialConverterService

    def runForecastImport() {
//        City.findAllByIsActive(true).each {
        City it = City.first() //{
            log.info("Starting import for the city ${it.printName}")
            WeatherForecast forecast = WeatherForecast.findByCity(it)
            if (!forecast) {
                log.info("Have not found forecast for ${it.printName}. Will be creating new")
                forecast = new WeatherForecast(city: it)
                forecast.save()
            }
            performCityForecast(forecast)
            log.info("End import for the city ${it.printName}")
//        }
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
        String url = "https://api.worldweatheronline.com/free/v2/weather.ashx?key=${API_KEY}&format=json&tp=3&num_of_days=8&extra=isDayTime&cc=no&q="
        String locStr = "${forecast.city.lat}".replaceAll(",", ".") + "," + "${forecast.city.lon}".replaceAll(",", ".")
        url + locStr
    }
}
