package com.tiempo

import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
import com.util.UiUtils
import org.apache.log4j.Logger
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class MainService {

    static transactional = false

    private static final log = Logger.getLogger(MainService.class)

    static final int HALF_DAY_MINS = 24 * 60 / 2

    static final Map<String, Long> TOP_SEARCHED_CITIES = new LinkedHashMap<>()

    static class WeatherView {
        City city
        Hourly current
        List<Hourly> todayHourlyList
        List<Day> forecast
        int halfDayPercent

        byte todayMaxDay
        byte todayMinNight

        Map<String, Long> topCities
    }

    WeatherView weatherView(Long cityId) {
        City city = City.findById(cityId)
        WeatherForecast forecast = WeatherForecast.findByCity(city.isWeatherImported ? city : city.basic)
        if (forecast) {
            DateTime currDateTime = new DateTime(DateTimeZone.forOffsetHours(city.region.country.tzOffset))
//            currDateTime = currDateTime.plusHours(1)
            Hourly nearest
            List<Day> forecastToShow
            try {
                Day day = forecast.getClientDay(currDateTime)
                nearest = forecast.provideCurrentHourly(currDateTime)
                forecastToShow = eliminateForecastToShow(day, forecast.forecast)
                return new WeatherView(city: city, forecast: forecastToShow, current: nearest, todayHourlyList: day.hours,
                        halfDayPercent: calcHalfDayPercent(currDateTime), todayMaxDay: day.maxDayTempC, todayMinNight: day.minNightTempC, topCities: topCities())
                //return new WeatherView(city: city, forecast: forecast.forecast, current: nearest, localDt: currDateTime)
            } catch (ForecastNotFoundException e) {
                log.error(e)
                return null
            }
        } else {
            return null
        }
    }

    public List<Long> citySearch(String key) {
        String cKey = UiUtils.capitalizeFirstLetter(key)
        City.executeQuery("select id from City where isActive = true and (printName like '" + cKey
                 + "%' or engName like '" + cKey + "%') order by searchPriority")
    }

    private static List<Day> eliminateForecastToShow(Day dayToEliminate, List<Day> forecast) {
        List<Day> forecastToShow = new ArrayList<>(forecast.size())
        for (Day forecastDay : forecast) {
            if (forecastDay.date.compareTo(dayToEliminate.date) > 0) {
                forecastToShow.add(forecastDay)
            }
        }
        forecastToShow
    }

    private static int calcHalfDayPercent(DateTime dateTime) {
        int minsOfDay = dateTime.getMinuteOfDay()
        if (minsOfDay <= HALF_DAY_MINS) {
            return Math.round(minsOfDay * 100 /HALF_DAY_MINS)
        } else {
            return Math.round((minsOfDay - HALF_DAY_MINS) * 100 / HALF_DAY_MINS)
        }
    }

    private static Map<String, Long> topCities() {
        if (TOP_SEARCHED_CITIES.size() == 0) {
            City.findAllByPopulationIsNotNull([max: 3, sort: "population", order: "desc"]).each {
                TOP_SEARCHED_CITIES.put(it.printName, it.id)
            }
        }
        TOP_SEARCHED_CITIES
    }
}
