package com.tiempo

import com.tiempo.wwo.Day
import com.tiempo.wwo.WeatherForecast

class MainController {

    def mainService
    def importService

    def index() {
    }

    def runImport() {
        log.info("Run import")
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

    def weatherResults(Long cityId) {
        MainService.WeatherView ww = mainService.weatherView(cityId)
        render(template: "weather_results", model: [weather: ww])
    }
}
