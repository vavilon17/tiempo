package com.tiempo

import com.dto.ui.WeatherView

class MainController {

    def mainService

    def index() {
        redirect(action: 'weather')
    }

    def weather() {
        WeatherView weatherView = mainService.weatherView(params.cityUrl)
        if (weatherView) {
            render(view: "/main/weather",  model: [weather_results: weatherView])
        } else {
            response.status = 404
        }
    }

    def search() {
        render(template: "/main/templates/city_search_results", model: [cityUrlParts: mainService.citySearch(params.cityName)])
    }
}
