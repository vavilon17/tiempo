package com.tiempo

import com.google.gson.Gson
import com.meteoprog.result.WeatherResult

class MainController {

    def restBridgeService

    def index() {
        render 'main'
    }

    def weather(String city) {
        render(view: 'index', model: [weather: restBridgeService.provideWeather(city)])

    }
}
