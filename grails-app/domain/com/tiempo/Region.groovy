package com.tiempo

class Region {

    String nativeName
    String urlName
    Country country

    static mapping = {
        id generator: 'assigned'
        version false
        urlName index: 'region_urlName_idx'
    }

    static constraints = {

    }
}
