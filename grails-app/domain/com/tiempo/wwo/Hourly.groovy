package com.tiempo.wwo

import com.tiempo.WeatherType
import com.util.DataUtils

import java.sql.Timestamp

class Hourly {

    String time
    Timestamp timestamp
    byte tempC
    byte hum
    float precip
    int pres
    int windMs
    int cloud
    int rainChance
    boolean isDay

    static transients = ['weatherType']

    static mapping = {
        timestamp index: 'hourly_timestamp_idx'
        isDay defaultValue: true
    }

    static constraints = {
        timestamp nullable: true
        windMs empty: true
        pres empty: true
        precip empty: true
        cloud empty: true
        rainChance empty: true
    }

    WeatherType getWeatherType() {
        DataUtils.calcWeatherType(isDay, precip, tempC, cloud)
    }
}
