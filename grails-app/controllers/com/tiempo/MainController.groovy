package com.tiempo

import grails.converters.JSON

class MainController {

    def mainService
    def importService

    def index() {
        render('hello')
    }

    def runImport() {
        importService.runForecastImport()
    }

    def weather(String city) {
        if (city != null && !city.isEmpty()) {
            WeatherForecast forecast = mainService.weather(city)
            if (forecast == null) {
                render(['err': 'Forecast not found'] as JSON)
            } else {
                render([result: forecast] as JSON)
            }
        } else {
            render(['err': 'City is empty'] as JSON)
        }
    }
}
