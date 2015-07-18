package com.tiempo

import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
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
