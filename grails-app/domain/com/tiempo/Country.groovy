package com.tiempo

class Country {

    static mapWith = "none"

    String nativeName
    String urlName
    String code

    boolean isActive

    static mapping = {
        version false
        urlName index: 'country_urlName_idx'
        code index: 'country_code_idx'
        isActive defaultValue: true
    }

    static constraints = {

    }
}
