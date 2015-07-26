package com.tiempo

import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
import org.apache.log4j.Logger
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class MainService {

    private static final log = Logger.getLogger(MainService.class)

    static final int HALF_DAY_MINS = 24 * 60 / 2

    static class WeatherView {
        City city
        Hourly current
        List<Day> forecast
        int halfDayPercent
    }

    static transactional = false

    WeatherView weatherView(Long cityId) {
        City city = City.findById(cityId)
        WeatherForecast forecast = WeatherForecast.findByCity(city)
        if (forecast) {
            DateTime currDateTime = new DateTime(DateTimeZone.forOffsetHours(city.region.country.tzOffset))
//            currDateTime = currDateTime.plusHours(1)
            Hourly nearest
            List<Day> forecastToShow
            try {
                Day day = forecast.getClientDay(currDateTime)
                nearest = forecast.provideCurrentHourly(currDateTime)
                forecastToShow = eliminateForecastToShow(day, forecast.forecast)
                return new WeatherView(city: city, forecast: forecastToShow, current: nearest, halfDayPercent: calcHalfDayPercent(currDateTime))
                //return new WeatherView(city: city, forecast: forecast.forecast, current: nearest, localDt: currDateTime)
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
            if (forecastDay.date.compareTo(dayToEliminate.date) > 0) {
                forecastToShow.add(forecastDay)
            }
        }
        forecastToShow
    }

    private static int calcHalfDayPercent(DateTime dateTime) {
        int minsOfDay = dateTime.getMinuteOfDay()
        if (minsOfDay <= HALF_DAY_MINS) {
            return Math.round(minsOfDay * 100 /HALF_DAY_MINS)
        } else {
            return Math.round((minsOfDay - HALF_DAY_MINS) * 100 / HALF_DAY_MINS)
        }
    }
}
