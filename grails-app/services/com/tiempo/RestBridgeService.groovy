package com.tiempo

import com.dto.CountryInfo
import com.dto.GeoObjectInfo
import com.google.gson.Gson
import com.meteoprog.result.CommonGeoObjResult
import com.meteoprog.result.CountriesResult
import com.meteoprog.result.WeatherResult
import com.tiempo.last.City
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

class RestBridgeService {

    static transactional = false

    def grailsApplication

    /*private final static Set COUNTRIES = ["Argentina", "Chili", "Uruguay", "Paraguay", "Brazil", "Bolivia", "Peru", "Ecuador",
                                      "Colombia", "Venezuela", "Guyana", "Suriname", "Panama", "CostaRica", "PuertoRico",
                                      "DominicanRepublic", "Cuba", "Nicaragua", "Honduras", "ElSalvador", "Belize", "Guatemala",
                                      "Mexico", "Jamaica", "Haiti", "Grenada", "TrinidadAndTobago", "Barbados", "Dominica"]*/

    private final static Set COUNTRIES = ["Argentina"]

    private static RestBuilder rest = new RestBuilder()

    CountriesResult countries() {
        def jsonRes = rest.get("${grailsApplication.config.meteoprog.api.main}/") {
            header 'Token', "${grailsApplication.config.meteoprog.api.token}"
        }
        new CountriesResult(JSON.parse(jsonRes.responseEntity.body))
    }

    CommonGeoObjResult regions(String country) {
        def jsonRes = rest.get("${grailsApplication.config.meteoprog.api.main}/${country}/") {
            header 'Token', "${grailsApplication.config.meteoprog.api.token}"
        }
        new CommonGeoObjResult(JSON.parse(jsonRes.responseEntity.body))
    }

    CommonGeoObjResult cities(String country, String region) {
        def jsonRes = rest.get("${grailsApplication.config.meteoprog.api.main}/${country}/${region}/") {
            header 'Token', "${grailsApplication.config.meteoprog.api.token}"
        }
        new CommonGeoObjResult(JSON.parse(jsonRes.responseEntity.body))
    }

    @Transactional
    def syncData() {
        CountriesResult countriesResult = countries()
        if (countriesResult.state == "success") {
            for (CountryInfo countryInfo : countriesResult.data) {
                if (COUNTRIES.contains(countryInfo.url)) {
                    log.info("Sync country: ${countryInfo.url}")
                    Country country = Country.findByUrlName(countryInfo.url)
                    if (!country) {
                        log.info("...Creating new...")
                        country = new Country(nativeName: countryInfo.name, urlName: countryInfo.url, code: countryInfo.alpha2)
                    } else {
                        country.nativeName = countryInfo.url
                        country.code = countryInfo.alpha2
                    }
                    country.save()
                    log.info("...save...")
                    CommonGeoObjResult regionsResult = regions(countryInfo.url)
                    if (regionsResult.state == "success") {
                        for (GeoObjectInfo regInfo : regionsResult.data) {
                            Region region = Region.findByUrlNameAndCountry(regInfo.url, country)
                            if (!region) {
                                region = new Region(nativeName: regInfo.name, urlName: regInfo.url, country: country)
                            } else {
                                region.nativeName = regInfo.name
                            }
                            region.save()
                            CommonGeoObjResult citiesRes = cities(country.urlName, region.urlName)
                            if (citiesRes.state == "success") {
                                for (GeoObjectInfo cityInfo : citiesRes.data) {
                                    City city = City.findByUrlNameAndRegion(cityInfo.url, region)
                                    if (!city) {
                                        city = new City(printName: cityInfo.name, urlName: cityInfo.url, region: region)
                                    } else {
                                        city.printName = cityInfo.name
                                    }
                                    city.save(failOnError: true)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    def provideWeather(String city) {
        def resp = rest.get("${grailsApplication.config.meteoprog.api.city}/${city}/") {
            header 'Token', "${grailsApplication.config.meteoprog.api.token}"
        }
        return new Gson().fromJson(resp.responseEntity.body, WeatherResult.class)
    }

    def fillCoordinates() {
        City.list().each { city ->
            WeatherResult res = provideWeather(city.urlName)
            city.lat = res.data.lat
            city.lon = res.data.lon
            city.save(failOnError: true)
        }
        City.first().save(flush: true)
    }
}
