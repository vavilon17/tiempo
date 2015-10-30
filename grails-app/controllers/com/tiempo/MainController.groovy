package com.tiempo

import com.dto.ui.WeatherView
import com.tiempo.exception.ForecastNotFoundException

class MainController {

    def mainService

    static defaultAction = "weather"

    def weather() {
        try {
            WeatherView weatherView = mainService.weatherView(params.cityUrl)
            render(view: "/main/weather",  model: [weather_results: weatherView])
        } catch (ForecastNotFoundException e) {
            response.status = 404
        } catch (Exception e) {
            response.status = 500
        }
    }

    def search() {
        render(template: "/main/templates/city_search_results", model: [cityUrlParts: mainService.citySearch(params.cityName)])
    }
}
