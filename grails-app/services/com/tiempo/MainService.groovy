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

    static final Map<String, String> TOP_SEARCHED_CITIES = new LinkedHashMap<>()

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

    public WeatherView weatherView(Long cityId) {
        City city = City.findById(cityId)
        weatherView(city)
    }

    public WeatherView weatherView(String urlPart, String countryCode) {
        Country country = Country.findByCode(countryCode)
        City city = City.findByCountryAndUrlPart(country, urlPart)
        weatherView(city)
    }

    public WeatherView weatherView(City city) {
        WeatherForecast forecast = WeatherForecast.findByCity(city.isWeatherImported ? city : city.basic)
        if (forecast) {
            DateTime currDateTime = new DateTime(DateTimeZone.forOffsetHours(city.country.tzOffset))
            Hourly nearest
            List<Day> forecastToShow
            try {
                Day day = forecast.getClientDay(currDateTime)
                nearest = forecast.provideCurrentHourly(currDateTime)
                forecastToShow = eliminateForecastToShow(day, forecast.forecast)
                return new WeatherView(city: city, forecast: forecastToShow, current: nearest, todayHourlyList: day.hours,
                        halfDayPercent: calcHalfDayPercent(currDateTime), todayMaxDay: day.maxDayTempC, todayMinNight: day.minNightTempC, topCities: topCities())
            } catch (ForecastNotFoundException e) {
                log.error(e)
                return null
            }
        } else {
            log.error("Forecast is not found for city ${city?.printName}!")
            return null
        }
    }

    public List<String> citySearch(String key) {
        String cKey = UiUtils.capitalizeFirstLetter(key)
        City.executeQuery("select urlPart from City where isActive = true and (printName like '" + cKey
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
            City.findAllByIsActiveAndPopulationIsNotNull(true, [max: 3, sort: "population", order: "desc"]).each {
                TOP_SEARCHED_CITIES.put(it.printName, it.urlPart)
            }
        }
        TOP_SEARCHED_CITIES
    }
}
