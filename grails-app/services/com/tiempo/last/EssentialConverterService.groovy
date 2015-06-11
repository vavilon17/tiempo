package com.tiempo.last

import com.dto.wwo.ForecastData
import com.dto.wwo.essential.DayEssential
import com.dto.wwo.essential.ForecastDataEssential
import com.dto.wwo.essential.HourlyEssential

class EssentialConverterService {

    static transactional = false

    ForecastDataEssential convert(ForecastData forecastData) {
        ForecastDataEssential esForecastData = new ForecastDataEssential()
        esForecastData.days = new ArrayList<>(forecastData.weather.size())
        forecastData.weather.each { w ->
            DayEssential esDay = new DayEssential()
            esDay.date = w.date
            esDay.minC = w.mintempC
            esDay.maxC = w.maxtempC
            esDay.hours = new ArrayList<>(w.hourly.size())
            w.hourly.each { h ->
                HourlyEssential esHourly = new HourlyEssential()
                esHourly.time = h.time
                esHourly.tempC = h.tempC
                esHourly.hum = h.humidity
                esHourly.precip = h.precipMM
                esHourly.pres = h.pressure
                esHourly.windMs = h?.windspeedMeterSec
                esDay.hours.add(esHourly)
            }
            esForecastData.days.add(esDay)
        }
        esForecastData
    }
}
