package com.tiempo.wwo

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

    static constraints = {
        timestamp nullable: true
        windMs empty: true
        pres empty: true
        precip empty: true
        cloud empty: true
        rainChance empty: true
    }
}
