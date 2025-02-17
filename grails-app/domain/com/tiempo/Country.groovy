package com.tiempo

class Country {

    String nativeName
    String urlName
    String code
    Integer importLimit
    double quotaCoef
    Integer radius

    boolean isActive

    static mapping = {
        version false
        urlName index: 'country_urlName_idx'
        code index: 'country_code_idx'
        isActive defaultValue: true
        quotaCoef defaultValue: 0
    }
}
