package com.tiempo

import com.dto.wwo.Astronomy
import com.dto.wwo.ForecastData
import com.dto.wwo.HourlyDto
import com.dto.wwo.Weather
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
import com.util.DataUtils

import java.sql.Timestamp

class EssentialConverterService {

    static transactional = true

    void refillForecast(WeatherForecast forecast, ForecastData forecastData) {
        List<Day> existingForecast = forecast.forecast
        Iterator<Day> iteratorDay = existingForecast.iterator()
        Day dayVar // temp variable to iterate over days forecast
        boolean allExistingDaysTraversed = false
        forecastData.weather.each { w ->
            if (!allExistingDaysTraversed && iteratorDay.hasNext()) {
                dayVar = iteratorDay.next()
            } else {
                allExistingDaysTraversed = true
                dayVar = new Day(hours: new ArrayList<Hourly>())
                forecast.addToForecast(dayVar)
            }
            mapWeatherDtoToDay(w, dayVar)
            refillHourly(dayVar, w)
            dayVar.save()
        }
        if (!allExistingDaysTraversed) {
            List<Day> toDel = new ArrayList<>()
            while (iteratorDay.hasNext()) {
                toDel.add(iteratorDay.next())
            }
            toDel.each {
                forecast.removeFromForecast(it)
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
            mapHourlyDtoToHourly(h, currentHourly, day)
            currentHourly.save()
        }
        // if we have more dat than in the forecast received - we just remove them
        if (!allTraversed) {
            List<Hourly> toDel = new ArrayList<>()
            while (iteratorHourly.hasNext()) {
                toDel.add(iteratorHourly.next())
            }
            toDel.each {
                day.removeFromHours(it)
            }
        }
    }

    private static mapWeatherDtoToDay(Weather weather, Day day) {
        day.date = DataUtils.yyyyMMdd.parse(weather.date)
        day.minC = weather.mintempC
        day.maxC = weather.maxtempC

        Astronomy astronomy = weather.astronomy.get(0)
        day.sunrise = new Timestamp(DataUtils.yyyyMMdd_hhmm_a.parse(weather.date + " " + astronomy.sunrise).getTime())
        day.sunset = new Timestamp(DataUtils.yyyyMMdd_hhmm_a.parse(weather.date + " " + astronomy.sunset).getTime())
    }

    private static mapHourlyDtoToHourly(HourlyDto hourlyDto, Hourly hourly, Day day) {
        hourly.time = DataUtils.prepareTime(hourlyDto.time)
        hourly.timestamp = DataUtils.prepareDayTimestamp(hourlyDto.time, day)
        hourly.tempC = hourlyDto.tempC
        hourly.hum = hourlyDto.humidity
        hourly.precip = hourlyDto.precipMM
        hourly.pres = hourlyDto.pressure
        hourly.cloud = hourlyDto.cloudcover
        hourly.rainChance = hourlyDto.chanceofrain
        hourly.windMs = calcWindSpeed(hourlyDto)
        hourly.isDay = calcIsDay(hourlyDto)
    }

    private static int calcWindSpeed(HourlyDto hourlyDto) {
        int res = 0
        try {
            res = hourlyDto.windspeedMeterSec
        } catch (Exception e) {
//            log.warn("Failed retrieving windspeedMeterSec ${e.getMessage()}. Will try windspeedKmph")
            try {
                if (hourlyDto.windspeedKmph) {
                    res = Math.round((hourlyDto.windspeedKmph * 1000) / 3600)
                }
            } catch (Exception ex) {
//                log.error("Cant retrieve wind speed: ${ex.getMessage()}")
            }
        }
        res
    }

    private static boolean calcIsDay(HourlyDto hourlyDto) {
        try {
            if (hourlyDto.isdaytime) {
                return hourlyDto.isdaytime.equalsIgnoreCase("yes")
            } else {
                return true
            }
        } catch (Exception e) {
            return true
        }
    }
}
