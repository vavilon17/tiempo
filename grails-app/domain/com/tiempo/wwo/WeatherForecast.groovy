package com.tiempo.wwo

import com.tiempo.City
import com.tiempo.exception.ForecastNotFoundException
import com.util.DataUtils
import org.joda.time.DateTime
import org.joda.time.LocalDateTime

import java.sql.Timestamp

class WeatherForecast {

    City city

    List<Day> forecast
    static hasMany = [forecast: Day]

    static transients = ['clientDay']

    static mapping = {
        forecast cascade: 'all-delete-orphan'
        city index: 'weather_forecast_city_idx'
    }

    static constraints = {
        forecast nullable: true, empty: true
    }

    Day getClientDay(DateTime inputDateTime) throws ForecastNotFoundException {
        String inputDateStr = inputDateTime.toString(DataUtils.yyyyMMdd_dt_formatter);
        for (Day d : forecast) {
            if (DataUtils.yyyyMMdd.format(d.date).equals(inputDateStr)) {
                return d
            }
        }
        throw new ForecastNotFoundException()
    }

    Hourly provideCurrentHourly(DateTime currentDateTime) throws ForecastNotFoundException {
        String inputDateStr = currentDateTime.toString(DataUtils.yyyyMMdd_dt_formatter);
        Day iteratorDay
        for (int i = 0; i < forecast.size(); i++) {
            iteratorDay = forecast.get(i)
            if (DataUtils.yyyyMMdd.format(iteratorDay.date).equals(inputDateStr)) {
                return generateAverageByDays(iteratorDay, forecast.get(i + 1), currentDateTime.toLocalDateTime())
            }
        }
        throw new ForecastNotFoundException("Cant find forecast for ${currentDateTime.toString()} and city ${city.printName}")
    }

    private Hourly generateAverageByDays(Day currentDay, Day nextDay, LocalDateTime currentLocalDateTime) throws ForecastNotFoundException  {
        Timestamp inputTime = new Timestamp(currentLocalDateTime.toDate().getTime())
        Hourly hourlyIter
        for (int i = 0; i < currentDay.hours.size(); i++) {
            hourlyIter = currentDay.hours.get(i)
            if (inputTime.before(hourlyIter.timestamp)) {
                if (i == 0) {
                    return hourlyIter
                } else {
                    boolean isDay = (inputTime.after(currentDay.sunrise) && inputTime.before(currentDay.sunset))
                    return generateAverageByHourly(currentDay.hours.get(i-1), hourlyIter, inputTime, isDay)
                }
            } else {
                if (i == currentDay.hours.size()-1) {
                    boolean isDay = (inputTime.before(currentDay.sunset) || inputTime.after(nextDay.sunrise))
                    return generateAverageByHourly(hourlyIter, nextDay.hours.get(0), inputTime, isDay)
                }
            }
        }
        throw new ForecastNotFoundException("Cant identify hourly range for day range [${currentDay.date.toString()}; " +
                "${nextDay.date.toString()}] and input datetime=${currentLocalDateTime.toString()}, city=${city.printName}")
    }

    private static Hourly generateAverageByHourly(Hourly before, Hourly after, Timestamp inputTimestamp, boolean isDay) {
        Hourly hourlyDto = new Hourly()
        double delta = (inputTimestamp.getTime() - before.timestamp.getTime()) / (after.timestamp.getTime() - before.timestamp.getTime())
        hourlyDto.timestamp = inputTimestamp
        hourlyDto.tempC = DataUtils.weightedIntAverage(before.tempC, after.tempC, delta)
        hourlyDto.hum = DataUtils.weightedIntAverage(before.hum, after.hum, delta)
        hourlyDto.precip = DataUtils.weightedFloatAverage(before.precip, after.precip, delta, 1)
        hourlyDto.pres = DataUtils.weightedIntAverage(before.pres, after.pres, delta)
        hourlyDto.windMs = DataUtils.weightedIntAverage(before.windMs, after.windMs, delta)
        hourlyDto.cloud = DataUtils.weightedIntAverage(before.cloud, after.cloud, delta)
        hourlyDto.rainChance = DataUtils.weightedIntAverage(before.rainChance, after.rainChance, delta)
        hourlyDto.isDay = isDay
        hourlyDto
    }
}
