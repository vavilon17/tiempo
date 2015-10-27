package com.tiempo

class MainController {

    def mainService

    def index() {
        redirect(action: 'weather')
    }

    def weather() {
        Long cityId
        if (params.cityId) {
            cityId = Long.valueOf(params.cityId)
        } else {
            cityId = City.findByAdminCode("PPLC").id
        }
        MainService.WeatherView weatherView = mainService.weatherView(cityId)
        render(view: "/main/weather",  model: [weather_results: weatherView])
    }

    def search() {
        render(template: "/main/templates/city_search_results", model: [cityIds: mainService.citySearch(params.cityName)])
    }
}
