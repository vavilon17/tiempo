package com.tiempo

class Region {

    String nativeName
    String urlName
    Country country
    String timezone

    Integer importId

    static mapping = {
        version false
        urlName index: 'region_urlName_idx'
        importId index: 'importId_country_idx'
        country index: 'importId_country_idx'
    }

    static constraints = {

    }
}
