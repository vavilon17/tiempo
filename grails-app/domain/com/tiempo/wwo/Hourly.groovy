package com.tiempo.wwo

import com.tiempo.WeatherType

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
        boolean isRain = precip >= 0.1
        if (isDay) {
            if (isRain) {
                if (tempC < 0) {
                    return WeatherType.SNOW
                } else {
                    if (cloud < 80) {
                        return WeatherType.SUN_CLOUD_RAIN
                    } else {
                        if (precip >= 2) {
                            return WeatherType.CLOUD_BIG_RAIN
                        } else {
                            return WeatherType.CLOUD_RAIN
                        }
                    }
                }
            } else {
                if (cloud < 20) {
                    return WeatherType.SUN
                } else if (cloud < 80) {
                    return WeatherType.SUN_CLOUD
                } else {
                    return WeatherType.CLOUD
                }
            }
        } else {
            if (isRain) {
                return WeatherType.MOON_CLOUD_RAIN
            } else {
                if (cloud < 20) {
                    return WeatherType.MOON
                } else if (cloud < 80) {
                    return WeatherType.MOON_CLOUD
                } else {
                    return WeatherType.CLOUD
                }
            }
        }
    }
}
