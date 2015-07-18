package com.tiempo.last.wwo

import org.joda.time.DateTime
import org.joda.time.LocalDateTime

import java.sql.Timestamp

class Day {

    Date date
    byte minC
    byte maxC

    List<Hourly> hours
    static hasMany = [hours: Hourly]

    static transients = ['nearestHourly']

    static mapping = {
        hours cascade: 'all-delete-orphan'
    }

    static constraints = {
        hours nullable: true, empty: true
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
