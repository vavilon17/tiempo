package com.tiempo.last

import com.tiempo.last.WeatherForecast
import grails.transaction.Transactional

/**
 * Created by yaskalv on 10.06.2015.
 */
class ImportService {

    static transactional = false

    static final API_KEY = "ffde3b758c4d6b6747cab9780cbff"

    def runForecastImport() {
        WeatherForecast.findAll().each {
            performCityForecast(it)
        }
    }

    @Transactional
    def performCityForecast(WeatherForecast forecast) {
        String url = prepareUrl(forecast)
        String content = url.toURL().getText("UTF-8")
        forecast.content = content.substring(0, 200)
        log.info("result = ${content}")
    }

    private String prepareUrl(WeatherForecast forecast) {
        String url = "https://api.worldweatheronline.com/free/v2/weather.ashx?key=${API_KEY}&format=json&cc=no&q="
        String locStr = "${forecast.city.lat}".replaceAll(",", ".") + "," + "${forecast.city.lon}".replaceAll(",", ".")
        url + locStr
    }
}
