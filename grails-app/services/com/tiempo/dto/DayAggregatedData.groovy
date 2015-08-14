package com.tiempo.dto


class DayAggregatedData {

    byte maxDayTempC = Byte.MIN_VALUE
    byte minNightTempC = Byte.MAX_VALUE

    int maxPressure = 0
    int maxHumidity = 0
    int maxWindMs = 0
    float sumPrecipMm = 0.00
    int maxRainChance = 0

}
