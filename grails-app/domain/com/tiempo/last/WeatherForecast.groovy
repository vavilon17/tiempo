package com.tiempo.last

class WeatherForecast {

    City city
    String content

    static constraints = {
        content nullable: true
    }
}
