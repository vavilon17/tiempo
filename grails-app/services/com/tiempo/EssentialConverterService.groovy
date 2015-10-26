package com.tiempo

import com.dto.wwo.Astronomy
import com.dto.wwo.ForecastData
import com.dto.wwo.HourlyDto
import com.dto.wwo.Weather
import com.tiempo.dto.DayAggregatedData
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
import com.util.DataUtils

import java.sql.Timestamp

class EssentialConverterService {

    private static final String DAY = "yes"
    private static final String NIGHT = "no"

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
        println("weather date = " + weather.date)
        day.date = DataUtils.yyyyMMdd.parse(weather.date)
        day.minC = weather.mintempC
        day.maxC = weather.maxtempC

        Astronomy astronomy = weather.astronomy.get(0)
        day.sunrise = new Timestamp(DataUtils.yyyyMMdd_hhmm_a.parse(weather.date + " " + astronomy.sunrise).getTime())
        day.sunset = new Timestamp(DataUtils.yyyyMMdd_hhmm_a.parse(weather.date + " " + astronomy.sunset).getTime())

        DayAggregatedData dayAggrData = calcAggregatedData(weather)
        day.maxDayTempC = dayAggrData.maxDayTempC
        day.minNightTempC = dayAggrData.minNightTempC
        day.maxPressure = dayAggrData.maxPressure
        day.maxHumidity = dayAggrData.maxHumidity
        day.maxWindMs = dayAggrData.maxWindMs
        day.sumPrecipMm = dayAggrData.sumPrecipMm
        day.maxRainChance = dayAggrData.maxRainChance
        day.avgDayWeatherType = dayAggrData.dayWeatherType
        day.avgNightWeatherType = dayAggrData.nightWeatherType
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

    private static DayAggregatedData calcAggregatedData(Weather dayWeather) {
        DayAggregatedData aggrData = new DayAggregatedData()
        int tmpWindSpeed

        int sumCloudVover = 0
        int sumDayTempC = 0
        int dayCount = 0
        int sumNightTempC = 0

        for (HourlyDto h : dayWeather.hourly) {
            // temperature edges
            if (h.isdaytime.equalsIgnoreCase(DAY)) {
                if (aggrData.maxDayTempC < h.tempC) {
                    aggrData.maxDayTempC = h.tempC
                }
                // for day weather type
                sumDayTempC += h.tempC
                dayCount++
            } else {
                if (aggrData.minNightTempC > h.tempC) {
                    aggrData.minNightTempC = h.tempC
                }
                // for night weather type
                sumNightTempC += h.tempC
            }

            // pressure, humidity, chance of rain
            if (aggrData.maxPressure < h.pressure) {
                aggrData.maxPressure = h.pressure
            }
            if (aggrData.maxHumidity < h.humidity) {
                aggrData.maxHumidity = h.humidity
            }
            if (aggrData.maxRainChance < h.chanceofrain) {
                aggrData.maxRainChance = h.chanceofrain
            }

            // summary precipitations
            aggrData.sumPrecipMm += h.precipMM

            // wind speed, m/sec
            tmpWindSpeed = calcWindSpeed(h)
            if (aggrData.maxWindMs < tmpWindSpeed) {
                aggrData.maxWindMs = tmpWindSpeed
            }

            sumCloudVover += h.cloudcover
        }
        int avgCloudCover = (int) Math.round(sumCloudVover*1.0/dayWeather.hourly.size())
        aggrData.dayWeatherType = DataUtils.calcWeatherType(true, aggrData.sumPrecipMm, (byte) Math.round(sumDayTempC*1.0/dayCount), avgCloudCover)
        aggrData.nightWeatherType = DataUtils.calcWeatherType(false, aggrData.sumPrecipMm, (byte) Math.round(sumNightTempC*1.0/(dayWeather.hourly.size() - dayCount)), avgCloudCover)
        aggrData
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
