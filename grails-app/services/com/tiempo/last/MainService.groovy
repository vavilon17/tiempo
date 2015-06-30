package com.tiempo.last

import com.tiempo.last.wwo.Day
import com.tiempo.last.wwo.Hourly

import java.sql.Timestamp

class MainService {

    static class WeatherView {
        City city
        Hourly current
        List<Day> forecast
    }

    static transactional = false

    WeatherForecast weather(String cityName) {
        City city = City.findByPrintName(cityName)
        if (city == null) {
            log.warn("City ${cityName} has not been found in the DB")
            return null
        }
        return WeatherForecast.findByCity(city.basic ?: city)
    }

    WeatherView weatherView(Long cityId, Timestamp time) {
        City city = City.findById(cityId)
        WeatherForecast forecast = WeatherForecast.findByCity(city)
        Hourly current = forecast.getClientDay(time).getNearestHourly(time)
        new WeatherView(city: city, forecast: forecast.forecast, current: current)
    }

}
