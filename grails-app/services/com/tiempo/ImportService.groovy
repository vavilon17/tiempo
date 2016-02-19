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

    private final Gson gson = new Gson();

    def essentialConverterService
    def importUrlProvider

    def runForecastImport() {
        runForecastImport(0, 0)
    }

    def runForecastImport(int offset, int limit) {
        List<City> cities = City.findAll("from City where isWeatherImported = true order by searchPriority, engName",
                [offset: offset, max: limit])
        performImportForCities(cities)
    }

    private void performImportForCities(List<City> cities) {
        int count = 0
        cities.each {
            WeatherForecast forecast = WeatherForecast.findByCity(it)
            if (!forecast) {
                log.info("Have not found forecast for ${it.printName}. Will be creating new")
                forecast = new WeatherForecast(city: it)
                forecast.save()
            }
            long start = System.currentTimeMillis()
            performCityForecast(forecast)
            count++
            log.info("City: ${it.printName}(${count}. Import duration: ${System.currentTimeMillis() - start}")
            if (count % 500 == 0) {
                log.info("Going to flush session. Items processed so far: ${count}")
                flushSession()
            }
        }
        flushSession()
        log.info("ImportService.runForecastImport finished. Items processed: ${count}")
    }

    @Transactional
    def performCityForecast(WeatherForecast forecast) {
        try {
            String url = prepareUrl(forecast)
            String content = url.toURL().getText("UTF-8")
            Root root = gson.fromJson(content, Root.class)
            essentialConverterService.refillForecast(forecast, root.data)
            forecast.save(failOnError: true)
        } catch (Exception e) {
            log.error("An error occurred while importing for city ${forecast.city.engName}: ${e.message}")
        }

    }

    private String prepareUrl(WeatherForecast forecast) {
        String url = importUrlProvider.provideUrlBase()
        String locStr = "&q=${forecast.city.lat}".replaceAll(",", ".") + "," + "${forecast.city.lon}".replaceAll(",", ".")
        url + locStr
    }

    private void flushSession() {
        Country.first().save(flush: true)
    }
}
