package com.tiempo

class Region {

    static mapWith = "none"

    String nativeName
    String urlName
    Country country

    boolean isActive

    static mapping = {
        version false
        urlName index: 'region_urlName_idx'
        isActive defaultValue: true
    }

    static constraints = {
    }
}
