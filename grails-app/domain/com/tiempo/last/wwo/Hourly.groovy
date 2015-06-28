package com.tiempo.last.wwo

class Hourly {

    String time
    byte tempC
    byte hum
    float precip
    int pres
    int windMs

    static constraints = {
        windMs empty: true
        pres empty: true
        precip empty: true
    }
}
