package com.tiempo.last

class City {

    String printName
    City basic
    float lat
    float lon

    static mapping = {
        id column: 'id', type: 'long'
        printName unique: true, index: 'printName_idx'
    }

    static constraints = {
        basic nullable: true
    }
}
