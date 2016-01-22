package com.tiempo

import com.dto.ui.WeatherView
import com.tiempo.exception.ForecastNotFoundException

class MainController {

    def mainService
    def grailsApplication

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

    def showRobots() {
        String countryCode = request.getHeader("COUNTRY_CODE")
        println "header COUNTRY_CODE = " + countryCode
        boolean isSubDomain = countryCode ? true : false
        render(template: '/main/templates/seo/robots', model: [isSubDomain: isSubDomain])
    }

    def showSitemap() {
        String countryCode = request.getHeader("COUNTRY_CODE")
        if (countryCode && grailsApplication.config.sitemapUrls.get(countryCode.toUpperCase())) {
            List<String> cityUrls = City.findAllByIsActive(true, [sort: 'searchPriority']).collect { it.urlPart }
            String baseUrl = grailsApplication.config.sitemapUrls["${countryCode.toUpperCase()}"].toString()
            render(template: '/main/templates/seo/country_sitemap', model: [cityUrls: cityUrls, baseUrl: baseUrl])
        } else {
            response.status = 404
        }
    }

    // AR
    def googleVer() {
        String countryCode = request.getHeader("COUNTRY_CODE")
        if (countryCode && "AR".equals(countryCode.toUpperCase())) {
            render(text: "google-site-verification: googleb092fb8796bb7e18.html")
        } else {
            response.status = 404
        }
    }

    // CL, UY, PY
    def googleVer2() {
        String countryCode = request.getHeader("COUNTRY_CODE")
        if (countryCode && ["CL", "UY", "PY"].contains(countryCode.toUpperCase())) {
            render(text: "google-site-verification: googlec4ec2d182d1725b9.html")
        } else {
            response.status = 404
        }
    }
}
