package com.tiempo.last

import com.tiempo.last.wwo.Day

import java.sql.Timestamp
import java.text.SimpleDateFormat

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

    Day getClientDay(Timestamp timestamp) {
        SimpleDateFormat sdf = EssentialConverterService.yyyyMMdd
        Date inputDate = sdf.parse(sdf.format(new Date(timestamp.getTime())))

        for (Day d : forecast) {
            if (String.valueOf(d.date.getTime()).equals(String.valueOf(inputDate.getTime()))) {
                return d
            }
        }
    }
}
