package com.tiempo.last

import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.last.wwo.Day
import com.tiempo.last.wwo.Hourly
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class MainService {

    static class WeatherView {
        City city
        Hourly current
        List<Day> forecast
        DateTime localDt
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

    WeatherView weatherView(Long cityId) {
        City city = City.findById(cityId)
        WeatherForecast forecast = WeatherForecast.findByCity(city)
        if (forecast) {
            DateTime currDateTime = new DateTime(DateTimeZone.forOffsetHours(city.region.country.tzOffset))
            Hourly nearest
            List<Day> forecastToShow
            try {
                Day day = forecast.getClientDay(currDateTime)
                nearest = day.getNearestHourly(currDateTime.toLocalDateTime())
                forecastToShow = eliminateForecastToShow(day, forecast.forecast)
                return new WeatherView(city: city, forecast: forecastToShow, current: nearest, localDt: currDateTime)
            } catch (ForecastNotFoundException e) {
                log.error(e)
                return null
            }
        } else {
            return null
        }
    }

    private static List<Day> eliminateForecastToShow(Day dayToEliminate, List<Day> forecast) {
        List<Day> forecastToShow = new ArrayList<>(forecast.size())
        for (Day forecastDay : forecast) {
            if (!forecastDay.date.equals(dayToEliminate.date)) {
                forecastToShow.add(forecastDay)
            }
        }
        forecastToShow
    }
}
