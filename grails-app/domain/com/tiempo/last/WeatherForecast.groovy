package com.tiempo.last

import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.last.wwo.Day
import com.util.DataUtils
import org.joda.time.DateTime

class WeatherForecast {

    City city

    List<Day> forecast
    static hasMany = [forecast: Day]

    static transients = ['clientDay']

    static mapping = {
        forecast cascade: 'all-delete-orphan'
    }

    static constraints = {
        forecast nullable: true, empty: true
    }

    Day getClientDay(DateTime inputDateTime) throws ForecastNotFoundException {
        String inputDateStr = inputDateTime.toString(DataUtils.yyyyMMdd_dt_formatter);
        for (Day d : forecast) {
            if (DataUtils.yyyyMMdd.format(d.date).equals(inputDateStr)) {
                return d
            }
        }
        throw new ForecastNotFoundException()
    }
}
