package com.tiempo.last

import com.tiempo.last.wwo.Day
import grails.converters.JSON

class MainController {

    def mainService
    def importService

    def index() {
    }

    def runImport() {
        importService.runForecastImport()
    }

    def del() {
        importService.convert(null)
        String dd = "sadasdasda"
    }

    def delDay() {
        Day day = Day.findByDate("2015-06-29")
        WeatherForecast f = WeatherForecast.findById(1l)
        f.removeFromForecast(day)
        f.save(flush: true) // id = 191, h: 183-190
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

    def weatherResults(Long cityId) {
        City city = City.findById(cityId)
        render(template: "weather_results", model: [forecast: mainService.weather(city.printName)])
    }
}
