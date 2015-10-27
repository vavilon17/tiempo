package com.tiempo

import com.data.CachedDataStore
import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

class GeoDataService {

    private static final Logger logger = Logger.getLogger(GeoDataService.class)

    static transactional = false

    static LinkedHashSet<String> ALLOWED_ADMIN_CODES = ["PPLC", "PPLA", "PPLA2", "PPLA3", "PPLA4", "PPL", "PPLS", "PPLL", "PPLCH", "PPLH", "PPLR"]

    def grailsApplication

    def importAndSetupGeoData(String countryCode) {
        Country country = Country.findByCode(countryCode)
        logger.info("*** Start filling geodata for ${country.nativeName}")
        importRegionsFromFile_Geodata(country)
        importCitiesFromFile_Geodata(country)
        setupCoreImportedCities(country)
        setCityRelationsInsideSameWeatherRegion(country)
        setupSearchPriority(country)
        logger.info("*** Finish filling geodata for ${country.nativeName}")
    }

    def fillCachedData() {
        logger.info("Preparing city full representations to be cached")
        Map<Long, String> data = new HashMap<Long, String>()
        City.findAllByIsActive(true).each {
            data.put(it.id, prepareCityFullRepresentation(it))
        }
        CachedDataStore.CITY_REPRESENTATIONS = data
        logger.info("Finish filling city cache")
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
        List<String> errors = []
        int count = 0
        if (importFile.exists()) {
            importFile.eachLine { line ->
                logger.info("Parsing following line: ${line}...")
                data = line.trim().split(";")
                if (ALLOWED_ADMIN_CODES.contains(data[5])) {
                    City city = new City(origId: Integer.parseInt(data[0]), printName: data[1], engName: data[2], isActive: false, lat: data[3],
                            lon: data[4], adminCode: data[5], population: data[7], searchPriority: 10000)
                    city.country = country
                    if (StringUtils.isEmpty(data[6])) {
                        logger.warn("Region is empty for current line! Please setup it manually")
                        errors.add("Region is empty for current line! Please setup it manually. Import line: ${line}")
                    } else {
                        city.region  = Region.findByImportIdAndCountry(Integer.valueOf(data[6]), country)
                    }
                    city.save(failOnError: true)
                    count++
                }
            }
            println "****************** IMPORT RESULT ******************"
            println "Imported ${count} items ${errors.size() > 0 ? '. Errors: ' : '. No errors occurred'}"
            errors.each {
                println("ERR: ${it}")
            }
            println("***************************************************")
        } else {
            logger.error("File doesnt exist")
        }
    }

    private void setupCoreImportedCities(Country country) {
        logger.info("Start calculation core import locations for country ${country.nativeName}. Limit = ${country.importLimit}")
        // first - clean all import setup
        City.findAllByCountry(country).each {
            it.isActive = false
            it.isWeatherImported = false
            it.save()
        }

        int maxAllowed = country.importLimit
        List<City> weatherTargets = []

        weatherTargets.addAll(City.findAll("from City where adminCode in ('PPLC', 'PPLA') and country.code = '" + country.code + "'"))
        weatherTargets.addAll(City.findAll("from City where adminCode not in ('PPLC', 'PPLA') and country.code = '" + country.code + "' order by population desc",
                [max: maxAllowed - weatherTargets.size()]))

        weatherTargets.each {
            it.isWeatherImported = true
            it.isActive = true
            it.save()
        }
        weatherTargets.first().save(flush: true)
        logger.info("Core import targets setup has finished")
    }

    private void setupSearchPriority(Country country) {
        List<Long> ids = []
        log.info("1. Capital and main cities")
        City capital = City.findByCountryAndAdminCode(country, "PPLC")
        capital.searchPriority = 1
        capital.save()
        ids << capital.id
        int searchPriority = 2
        City.findAll("from City where country.code = '" + country.code + "' and adminCode = 'PPLA' order by population desc").each {
            it.searchPriority = searchPriority++
            it.save()
            ids << it.id
        }
        log.info("2. Other cities with filled population")
        City.findAll("from City where id not in " + prepareListRepresentation(ids) + " and country.code = '" +
                country.code + "' and population > 0 order by population desc").each {
            it.searchPriority = searchPriority++
            it.save()
        }
        log.info("3. The rest cities")
        City.findAllByCountryAndPopulation(country, 0, [sort: 'printName']).each {
            it.searchPriority = searchPriority++
            it.save()
        }
        capital.save(flush: true)
    }

    private void setCityRelationsInsideSameWeatherRegion(Country country) {
        logger.info("**** Calculation closest cities from imported locations in ${country.nativeName} - started")
        List<City> importCities = City.findAllByCountryAndIsWeatherImported(country, true)
        List<Integer> importIds = importCities.collect {it.id.intValue()}
        List<City> otherCities = City.findAllByCountryAndIdNotInList(country, importIds)
        List<String> result = []
        double radius = "${grailsApplication.config.geodata.weather_region_radius_km}".toDouble()
        importCities.each { importCity ->
            logger.info("Looking for ${importCity.printName}")
            otherCities.each { otherCity ->
                double dist = calcDistance(importCity, otherCity)
                if (dist <= radius) {
                    result << "${dist} km between ${importCity.printName} and ${otherCity.printName}"
                    otherCity.isActive = true
                    otherCity.basic = importCity
                    otherCity.save()
                }
            }
        }
        logger.info("*** Closest cities items found: ${result.size()}")
        result.each {logger.info(it)}
        importCities.first().save(flush: true)
        logger.info("**** Calculation closest cities from imported locations in ${country.nativeName} - finished")
    }

    private static double calcDistance(City city1, City city2) {
        double latDiff = city1.lat - city2.lat
        double lonDiff = city1.lon - city2.lon
        Math.sqrt(latDiff*latDiff + lonDiff*lonDiff) * 100
    }

    private static String prepareListRepresentation(List<Long> list) {
        StringBuilder listStr = new StringBuilder("(")
        list.each {
            listStr.append(it).append(", ")
        }
        listStr.replace(listStr.lastIndexOf(","), listStr.length(), ")")
        listStr.toString()
    }

    private static String prepareCityFullRepresentation(City city) {
        new StringBuilder(city.printName).append(", ").append(city.region.nativeName).append(", ")
                .append(city.country.nativeName).toString()
    }
}
