package com.tiempo.last

import com.dto.wwo.ForecastData
import com.dto.wwo.Weather
import com.dto.wwo.essential.DayEssential
import com.dto.wwo.essential.ForecastDataEssential
import com.dto.wwo.essential.HourlyEssential
import com.tiempo.last.wwo.Day
import com.tiempo.last.wwo.Hourly

import java.text.SimpleDateFormat

class EssentialConverterService {

    static transactional = true
    static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd")

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
//                esHourly.windMs = h?.windspeedMeterSec
                esDay.hours.add(esHourly)
            }
            esForecastData.days.add(esDay)
        }
        esForecastData
    }

    void refillForecast(WeatherForecast forecast, ForecastData forecastData) {
        boolean first = true
        Day current = forecast.currentDay // the day with current date
        List<Day> existingForecast = forecast.forecast
        Iterator<Day> iteratorDay = existingForecast.iterator()
        Day dayVar // temp variable to iterate over days forecast
        boolean allExistingDaysTraversed = false
        forecastData.weather.each { w ->
            Iterator<Hourly> iteratorHourly
            if (first) {
                first = false
                if (current) {
                    Date currentDate = yyyyMMdd.parse(current.date)
                    Date importedDate = yyyyMMdd.parse(w.date)
                    if (currentDate.compareTo(importedDate) < 0) {
                        current.date = w.date
                    }
                    current.minC = w.mintempC
                    current.maxC = w.maxtempC
                } else {
                    current = new Day(date: w.date, minC: w.maxtempC, maxC: w.maxtempC, hours: new ArrayList<Hourly>())
                    forecast.currentDay = current
                }
                refillHourly(current, w)
                current.save()
            } else {
                if (!allExistingDaysTraversed && iteratorDay.hasNext()) {
                    dayVar = iteratorDay.next()
                } else {
                    allExistingDaysTraversed = true
                    dayVar = new Day(hours: new ArrayList<Hourly>())
                    forecast.addToForecast(dayVar)
                }
                dayVar.date = w.date
                dayVar.minC = w.mintempC
                dayVar.maxC = w.maxtempC
                refillHourly(dayVar, w)
                dayVar.save()
            }
        }
        if (!allExistingDaysTraversed) {
            while (iteratorDay.hasNext()) {
                forecast.removeFromForecast(iteratorDay.next())
            }
        }
    }

    private void refillHourly(Day day, Weather weather) {
        Iterator<Hourly> iteratorHourly = day.hours.iterator()
        Hourly currentHourly
        boolean allTraversed = false
        weather.hourly.each { h ->
            if (!allTraversed && iteratorHourly.hasNext()) {
                currentHourly = iteratorHourly.next()
            } else {
                allTraversed = true
                currentHourly = new Hourly()
                day.addToHours(currentHourly)
            }
            currentHourly.time = h.time
            currentHourly.tempC = h.tempC
            currentHourly.hum = h.humidity
            currentHourly.precip = h.precipMM
            currentHourly.pres = h.pressure
//            currentHourly.windMs = h?.windspeedMeterSec
            currentHourly.save()
        }
        // if we have more dat than in the forecast received - we just remove them
        if (!allTraversed) {
            while (iteratorHourly.hasNext()) {
                day.removeFromHours(iterator().next())
            }
        }
    }
}
