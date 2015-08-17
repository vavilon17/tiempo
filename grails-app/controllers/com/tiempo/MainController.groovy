package com.tiempo

import org.apache.log4j.Logger

class MainController {

    def mainService
    def importService

    private static final log = Logger.getLogger(MainController.class)

    static final String DEFAULT_CITY_NAME = "Buenos Aires Province-BuenosAiresProvince"

    def index() {
        redirect(action: 'weather')
    }

    def index2() {
        render(view: 'index2')
    }

    def runImport() {
        log.info("Run import")
        importService.runForecastImport()
    }

    def weather() {
        Long cityId
        if (params.cityId) {
            cityId = Long.valueOf(params.cityId)
        } else {
            cityId = City.findByUrlName(DEFAULT_CITY_NAME).id
        }
        MainService.WeatherView weatherView = mainService.weatherView(cityId)
        render(view: "/main/weather",  model: [weather_results: weatherView])
    }

    def search() {
        List<City> cities = City.findAllByPrintNameIlike("${params.cityName}%".toString())
        render(template: "/main/templates/city_search_results", model: [cities: cities])
    }

    def weatherResults(Long cityId) {
        MainService.WeatherView ww = mainService.weatherView(cityId)
        render(template: "weather_results", model: [weather: ww])
    }
}
