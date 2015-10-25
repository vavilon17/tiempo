package com.tiempo

import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

class GeoDataService {

    private static final Logger logger = Logger.getLogger(GeoDataService.class)

    static transactional = false

    static LinkedHashSet<String> ALLOWED_ADMIN_CODES = ["PPLC", "PPLA", "PPLA2", "PPLA3", "PPLA4", "PPL", "PPLS", "PPLL", "PPLCH", "PPLH", "PPLR"]

    def grailsApplication

    def importAndSetupGeoData(String countryCode) {
        Country country = Country.findByCode(countryCode)
        importRegionsFromFile_Geodata(country)
        importCitiesFromFile_Geodata(country)
    }

    private void importRegionsFromFile_Geodata(Country country) {
        logger.info("Start regions import")
        File importFile = new File("data/${country.code}/reg.csv")
        String[] data
        if (importFile.exists()) {
            importFile.eachLine { line ->
                logger.info("Parsing following line: ${line}")
                data = line.trim().split(";")
                Region region = new Region(importId: Integer.valueOf(data[0]), nativeName: data[1], urlName: data[2])
                region.country = country
                region.save(failOnError: true, flush: true)
            }
            logger.info("Regions import finished")
        } else {
            logger.error("File doesn't exist")
        }
    }

    private void importCitiesFromFile_Geodata(Country country) {
        File importFile = new File("data/${country.code}/cities.csv")
        String[] data
        int count = 0
        if (importFile.exists()) {
            importFile.eachLine { line ->
                logger.info("Parsing following line: ${line}...")
                data = line.trim().split(";")
                if (ALLOWED_ADMIN_CODES.contains(data[5])) {
                    City city = new City(origId: Integer.parseInt(data[0]), printName: data[1], urlName: data[2], isActive: false, lat: data[3], lon: data[4], adminCode: data[5], population: data[7])
                    if (StringUtils.isEmpty(data[6])) {
                        logger.warn("Region is empty for current line! Please setup it manually")
                    } else {
                        city.region  = Region.findByImportIdAndCountry(Integer.valueOf(data[6]), country)
                    }
                    city.save(failOnError: true)
                    count++
                }
            }
            println "*********************"
            println "Imported ${count} items"
        } else {
            logger.error("File doesnt exist")
        }
    }

    def setupCoreImportedCities(Country country) {
        // first - clean all import setup
        String countryFilterQueryPart = "region is not null and region.country.code = '" + country.code +  "'"
        City.executeUpdate("update City set isActive = false where ${countryFilterQueryPart}")
        City.executeUpdate("update City set isWeatherImported = false where ${countryFilterQueryPart}")

        int maxAllowed = "${grailsApplication.config.geodata.weather_targets_max}".toInteger()
        List<City> weatherTargets = []

        weatherTargets.addAll(City.findAll("from City where adminCode in ('PPLC', 'PPLA') and ${countryFilterQueryPart}"))
        weatherTargets.addAll(City.findAll("from City where adminCode not in ('PPLC', 'PPLA') and ${countryFilterQueryPart} order by population desc",
                [max: maxAllowed - weatherTargets.size()]))

        weatherTargets.each {
            it.isWeatherImported = true
            it.isActive = true
            it.save()
        }
        weatherTargets.first().save(flush: true)
    }

    def setCityRelationsInsideSameWeatherRegion() {
        List<City> importCities = City.findAllByIsWeatherImported(true)
        List<Integer> importIds = importCities.collect {it.id}
        List<City> otherCities = City.findAllByIdNotInList(importIds)
        List<String> result = []
        importCities.each { importCity ->
            println("Looking for ${importCity.printName}")
            otherCities.each { otherCity ->
                float dist = calcDistance(importCity, otherCity)
                if (dist <= 12) {
                    result << "${dist} km between ${importCity.printName} and ${otherCity.printName}"
                    otherCity.isActive = true
                    otherCity.basic = importCity
                    otherCity.save()
                }
            }
        }
        println "*** Closest cities items found: ${result.size()}"
        result.each {println it}
        importCities.first().save(flush: true)
    }

    private static double calcDistance(City city1, City city2) {
        double latDiff = city1.lat - city2.lat
        double lonDiff = city1.lon - city2.lon
        Math.sqrt(latDiff*latDiff + lonDiff*lonDiff) * 100
    }


}
