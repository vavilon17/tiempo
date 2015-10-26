package com.tiempo

class City {

    String printName
    String urlName
    City basic
    float lat
    float lon
    Region region
    Integer population
    String adminCode

    Country country

    boolean isActive // meaning whether the city is available from UI to show local wether
    boolean isWeatherImported // meaning whether the city is an import target while dealing with Weather API

    Integer origId
    Integer searchPriority

    static transients = ['fullRepresentation']

    static mapping = {
        id column: 'id', type: 'long'
        isActive defaultValue: true
        adminCode length: 20
        isWeatherImported default: false
        searchPriority default: 5000, index: 'city_search_priority_idx'
        printName unique: false, index: 'city_print_name_idx'
        urlName index: 'city_country_url_name_idx'
        country index: 'city_country_url_name_idx'
    }

    static constraints = {
        basic nullable: true
        urlName nullable: true
        region nullable: true
        population nullable: true
        origId nullable: true
        adminCode nullable: true
    }

    String getFullRepresentation() {
        new StringBuilder(printName).append(", ").append(region.nativeName).append(", ").append(country.nativeName).toString()
    }
}
