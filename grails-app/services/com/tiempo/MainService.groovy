package com.tiempo

class MainService {

    static transactional = false

    static final float LON_LAT_COEF = 82.2f;
    static final float LIMIT_DIST_KM = 15f;

    WeatherForecast weather(String cityName) {
        City city = City.findByPrintName(cityName)
        if (city == null) {
            log.warn("City ${cityName} has not been found in the DB")
            return null
        }
        return WeatherForecast.findByCity(city.basic ?: city)
    }

}
