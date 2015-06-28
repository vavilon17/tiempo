package com.tiempo.old

import com.tiempo.Region

class City {

    static mapWith = "none"

    String nativeName
    String urlName
    Region region
    String code

    boolean isActive

    static mapping = {
        version false
        isActive defaultValue: true
        nativeName index: 'city_nativeName_idx'
        urlName index: 'city_urlName_idx'
    }

    static constraints = {
        code nullable: true
    }
}
