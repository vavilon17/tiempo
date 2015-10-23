package com.tiempo

class Country {

    String nativeName
    String urlName
    String code
    String primaryLangCode
    Integer tzOffset

    boolean isActive

    static mapping = {
        version false
        urlName index: 'country_urlName_idx'
        code index: 'country_code_idx'
        isActive defaultValue: true
        tzOffset defaultValue: 0
    }

    static constraints = {
        tzOffset nullable: true
    }
}
