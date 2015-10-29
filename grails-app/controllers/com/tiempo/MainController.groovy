package com.tiempo

class MainController {

    def mainService

    def index() {
        redirect(action: 'weather')
    }

    def weatherOld() {
        Long cityId
        if (params.cityId) {
            cityId = Long.valueOf(params.cityId)
        } else {
            cityId = City.findByAdminCode("PPLC").id
        }
        MainService.WeatherView weatherView = mainService.weatherView(cityId)
        render(view: "/main/weather",  model: [weather_results: weatherView])
    }

    def weather() {
        MainService.WeatherView weatherView = mainService.weatherView(params.cityUrl, "AR")
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
