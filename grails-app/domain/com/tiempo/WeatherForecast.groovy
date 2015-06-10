package com.tiempo

class WeatherForecast {

    City city
    String content

    static constraints = {
        content nullable: true
    }
}
