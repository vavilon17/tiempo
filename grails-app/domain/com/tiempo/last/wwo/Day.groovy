package com.tiempo.last.wwo

class Day {

    String date
    byte minC
    byte maxC

    List<Hourly> hours
    static hasMany = [hours: Hourly]

    static mapping = {
        hours cascade: 'all-delete-orphan'
    }

    static constraints = {
        hours nullable: true, empty: true
    }
}
