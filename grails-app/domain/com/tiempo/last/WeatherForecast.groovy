package com.tiempo.last

import com.tiempo.last.wwo.Day

class WeatherForecast {

    City city
    Day currentDay

    List<Day> forecast
    static hasMany = [forecast: Day]

    static mapping = {
        currentDay cascade: 'delete'
        forecast cascade: 'all-delete-orphan'
    }

    static constraints = {
        currentDay nullable: true
        forecast nullable: true, empty: true
    }
}
