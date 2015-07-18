package com.tiempo.last

import com.tiempo.Country
import com.tiempo.Region

class City {

    String printName
    String urlName
    City basic
    float lat
    float lon
    Region region
    String code
    Integer population
    boolean isActive

    static transients = ['lookupTitle, fullRepresentation']

    static mapping = {
        id column: 'id', type: 'long'
        isActive defaultValue: true
//        printName unique: true, index: 'printName_idx'
    }

    static constraints = {
        basic nullable: true
        urlName nullable: true
        region nullable: true
        code nullable: true
        population nullable: true
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
