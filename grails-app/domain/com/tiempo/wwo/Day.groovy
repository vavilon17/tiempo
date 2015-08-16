package com.tiempo.wwo

import com.tiempo.WeatherType
import org.joda.time.LocalDateTime

import java.sql.Timestamp

class Day {

    Date date
    byte minC
    byte maxC

    // aggregated part
    byte maxDayTempC
    byte minNightTempC
    int maxPressure
    int maxHumidity
    int maxWindMs
    float sumPrecipMm
    int maxRainChance

    WeatherType avgDayWeatherType
    WeatherType avgNightWeatherType

    Timestamp sunrise
    Timestamp sunset

    List<Hourly> hours
    static hasMany = [hours: Hourly]

    static transients = ['nearestHourly']

    static mapping = {
        hours cascade: 'all-delete-orphan'
    }

    static constraints = {
        hours nullable: true, empty: true
        avgDayWeatherType nullable: true
        avgNightWeatherType nullable: true
    }

    Hourly getNearestHourly(LocalDateTime localDateTime) {
        Timestamp inputTime = new Timestamp(localDateTime.toDate().getTime())
        Hourly prev = null
        for (Hourly h : hours) {
            if (inputTime.before(h.timestamp)) {
                if (prev == null) {
                    return h
                } else {
                    long diff1 = inputTime.getTime() - prev.timestamp.getTime()
                    long diff2 = h.timestamp.getTime() - inputTime.getTime()
                    if (diff1 > diff2) {
                        return h
                    } else {
                        return prev
                    }
                }
            }
            prev = h
        }
        return prev
    }
}
