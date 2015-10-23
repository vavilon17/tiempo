package com.tiempo

import com.dto.geonames.CitiesResult
import com.dto.geonames.CityInfo
import com.rest.RestBuilderFactory
import grails.converters.JSON
import grails.transaction.Transactional
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

class GeoDataService {

    private static final Logger logger = Logger.getLogger(GeoDataService.class)

    static transactional = false

    static Set<String> ALLOWED_ADMIN_CODES = ["PPL", "PPLA", "PPLA2", "PPLA3", "PPLA4", "PPLC", "PPLCH", "PPLH", "PPLL", "PPLR", "PPLS"]

    def grailsApplication

    def fillGeoData(String countryCode) {
        logger.info("Start filling geodata for country with code = ${countryCode}")
        Country country = Country.findByCode(countryCode)
        if (country) {
            importCitiesFromGeonames(country)
        } else {
            logger.error("Cant find the country with code ${countryCode}")
        }
    }

    def importCitiesFromGeonames(Country country) {
        /*float step = "${grailsApplication.config.geodata.country_square_step}".toFloat()

        float startWest = country.west
        float startNorth = country.north
        float finishEast = country.east
        float finishSouth = country.south
        int portion = 0
        for (float west = startWest; west < finishEast; west += step) {
            for (float north = startNorth; north > finishSouth; north -= step) {
                importCitiesFromGeonamesSquare(country, north, (float) north - step, west, (float) west + step, portion)
                portion++
            }
        }*/
    }

    def importRegionsFromFile_Geodata(String filePath) {
        logger.info("Start regions import")
        File importFile = new File(filePath)
        String[] data
        if (importFile.exists()) {
            importFile.eachLine { line ->
                logger.info("Parsing following line: ${line}")
                data = line.trim().split(";")
                Region region = new Region(nativeName: data[1], urlName: data[2])
                region.id = Long.parseLong(data[0])
                region.country = Country.findByCode("AR")
                region.save(failOnError: true, flush: true)
            }
            logger.info("Regions import finished")
        } else {
            logger.error("File doesn't exist")
        }
    }

    def importCitiesFromFile_Geodata(String filePath) {
        File importFile = new File(filePath)
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
                        Region reg  = Region.findById(Long.parseLong(data[6]))
                        city.region = reg
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

    def setupCoreImportedCities() {
        int maxAllowed = "${grailsApplication.config.geodata.weather_targets_max}".toInteger()
        Set<City> weatherTargets = new HashSet<>()
        // first include capital
        Collections.addAll(weatherTargets, City.findAllByAdminCode("PPLC"))
        if (weatherTargets.size() < maxAllowed) {
            // then include admin centers of 1 level
            Collections.addAll(weatherTargets, City.findAll("from City where adminCode = 'PPLA'", ))
        }
    }

    @Transactional
    def setCityRelationsInsideSameWeatherRegion() {
        List<City> activeCities = City.findAll("from City order by population desc", [max:500])
        List<Integer> activeIds = activeCities.collect {it.id}
        List<City> passiveCities = City.findAllByIdNotInList(activeIds)
        List<String> result = []
        activeCities.each { activeCity ->
            println("Looking for ${activeCity.printName}")
            passiveCities.each { passiveCity ->
                float dist = calcDistance(activeCity, passiveCity)
                if (dist <= 13) {
                    result << "${dist} km between ${activeCity.printName} and ${passiveCity.printName}"
                }
            }
        }
        println "*** Closest cities items found: ${result.size()}"
        result.each {println it}
    }

    def setupRegionNameAndUrlPartForActualCities() {

    }

    private static double calcDistance(City city1, City city2) {
        double latDiff = city1.lat - city2.lat
        double lonDiff = city1.lon - city2.lon
        Math.sqrt(latDiff*latDiff + lonDiff*lonDiff) * 100
    }


}
