package com.tiempo

import org.apache.log4j.Logger

class CacheService {

    static transactional = false

    private static final Logger logger = Logger.getLogger(CacheService.class)

    public static final Map<String, String> CITY_REPRESENTATIONS = new HashMap<>()
    public static final Map<String, Long> COUNTRY_CAPITAL_IDS = new HashMap<>()

    def fillCache() {
        logger.info("Fill cache...")
        fillCityRepresentations()
        fillCapitals()
        logger.info("Finish filling cache")
    }

    private void fillCityRepresentations() {
        logger.info("Preparing city full representations to be cached")
        CITY_REPRESENTATIONS.clear()
        City.findAllByIsActive(true).each {
            CITY_REPRESENTATIONS.put(it.urlPart, prepareCityFullRepresentation(it))
        }
        logger.info("Finish filling city cache")
    }

    private void fillCapitals() {
        COUNTRY_CAPITAL_IDS.clear()
        Country.findAll().each { country ->
            COUNTRY_CAPITAL_IDS.put(country.code, City.findByCountryAndAdminCode(country, "PPLC").id)
        }
    }

    private static String prepareCityFullRepresentation(City city) {
        new StringBuilder(city.printName).append(", ").append(city.region.nativeName).append(", ")
                .append(city.country.nativeName).toString()
    }
}
