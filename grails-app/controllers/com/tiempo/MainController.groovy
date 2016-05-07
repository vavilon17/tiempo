package com.tiempo

import com.dto.ui.WeatherView
import com.tiempo.exception.ForecastNotFoundException

import javax.servlet.http.HttpServletResponse

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
            // todo logging
            response.status = 500
        }
    }

    def search() {
        render(template: "/main/templates/city_search_results", model: [cityUrlParts: mainService.citySearch(params.cityName)])
    }

    def showRobots() {
        try {
            String sitemapRoot = grailsApplication.config.sitemapRoot.toString()
            byte[] data = new File("${sitemapRoot}/robots.txt").getBytes()
            response.setHeader('Content-length', String.valueOf(data.length))
            response.setHeader('Cache-Control', "public, must-revalidate")
            response.contentType = "text/plain"
            response.outputStream << data
            response.outputStream.flush()
        } catch (Exception ioEx) {
            response.status = 404
        }
//        render(template: '/main/templates/seo/robots')
    }

    def showSitemap() {
        try {
            lookupSitemapFile("sitemap.xml", response)
        } catch (Exception ioEx) {
            response.status = 404
        }
    }

    def showCountrySitemap(String countryCode) {
        /*if (countryCode) {
            Country country = Country.findByCode(countryCode)
            List<String> cityUrls = City.findAllByCountryAndIsActive(country, true, [sort: 'searchPriority']).collect { it.urlPart }
            String baseUrl = grailsApplication.config.baseDomain.toString()
            render(template: '/main/templates/seo/country_sitemap', model: [cityUrls: cityUrls, baseUrl: baseUrl])
        } else {
            response.status = 404
        }*/
        try {
            lookupSitemapFile("sitemap-${countryCode}.xml", response)
        } catch (Exception ioEx) {
            response.status = 404
        }
    }

    private void lookupSitemapFile(String fileName, HttpServletResponse resp) throws IOException {
        String sitemapRoot = grailsApplication.config.sitemapRoot.toString()
        byte[] data = new File("${sitemapRoot}/${fileName}").getBytes()
        resp.setHeader('Content-length', String.valueOf(data.length))
        resp.setHeader('Cache-Control', "public, must-revalidate")
        resp.contentType = "text/xml"
        resp.outputStream << data
        resp.outputStream.flush()
    }

    def googleVer() {
        render(text: "google-site-verification: googlea0c97031d7b7720d.html")
    }
}
