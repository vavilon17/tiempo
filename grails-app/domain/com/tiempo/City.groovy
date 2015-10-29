package com.tiempo

class City {

    String printName
    String engName
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

    String urlPart

    static mapping = {
        id column: 'id', type: 'long'
        isActive defaultValue: true
        adminCode length: 20
        isWeatherImported defaultValue: false
        searchPriority defaultValue: 5000, index: 'city_search_priority_idx'
        printName unique: false, index: 'city_print_name_idx'
        engName unique: false, index: 'city_eng_name_idx'
        urlPart index: 'city_urlPart_country_idx'
        country index: 'city_urlPart_country_idx'
    }

    static constraints = {
        basic nullable: true
        engName nullable: true
        region nullable: true
        population nullable: true
        origId nullable: true
        adminCode nullable: true
        urlPart nullable: true
    }
}
