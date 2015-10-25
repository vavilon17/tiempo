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

    String countryCode

    boolean isActive // meaning whether the city is available from UI to show local wether
    boolean isWeatherImported // meaning whether the city is an import target while dealing with Weather API

    Integer origId

    static transients = ['lookupTitle, fullRepresentation']

    static mapping = {
        id column: 'id', type: 'long'
        isActive defaultValue: true
        adminCode length: 20
        isWeatherImported default: false
    }

    static constraints = {
        basic nullable: true
        urlName nullable: true
        region nullable: true
        population nullable: true
        origId nullable: true
        adminCode nullable: true
    }

    String getLookupTitle() {
        StringBuilder sb = new StringBuilder(printName)
        if (region) {
            sb.append(", ").append(region.nativeName)
        }
        sb.toString()
    }

    String getFullRepresentation() {
        StringBuilder sb = new StringBuilder(printName)
        if (region) {
            sb.append(", ").append(region.country.nativeName).append(" (").append(region.nativeName).append(")")
        }
        sb.toString()
    }
}
