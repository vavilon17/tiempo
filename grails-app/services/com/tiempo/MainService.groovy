package com.tiempo

import com.dto.ui.WeatherView
import com.tiempo.exception.ForecastNotFoundException
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly
import com.tiempo.wwo.WeatherForecast
import com.util.UiUtils
import org.apache.log4j.Logger
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.springframework.web.context.request.RequestContextHolder

class MainService {

    static transactional = false

    private static final log = Logger.getLogger(MainService.class)

    static final int HALF_DAY_MINS = 24 * 60 / 2
    static final String DEF_COUNTRY_CODE = "AR"
    static final String COUNTRY_CODE_HEADER = "COUNTRY_CODE"
    static final Map<String, String> TOP_SEARCHED_CITIES = new LinkedHashMap<>()

    public WeatherView weatherView(String urlPart) {
        City city
        if (urlPart) {
            city = City.findByUrlPart(urlPart)
        } else {
            String countryCode = lookupCountryCodeFromHeader()
            city = City.findById(CacheService.COUNTRY_CAPITAL_IDS.get(countryCode))
        }
        weatherViewForCity(city)
    }

    public List<String> citySearch(String key) {
        String cKey = UiUtils.capitalizeFirstLetter(key)
        City.executeQuery("select urlPart from City where isActive = true and (printName like '" + cKey
                + "%' or engName like '" + cKey + "%') order by searchPriority")
    }

    private String lookupCountryCodeFromHeader() {
        log.info("lookup contry code from header")
        String countryCode = RequestContextHolder.currentRequestAttributes().getHeader(COUNTRY_CODE_HEADER)
        if (!countryCode) {
            log.warn("No header found. Will be used default value - ${DEF_COUNTRY_CODE}")
            countryCode = DEF_COUNTRY_CODE
        }
        countryCode
    }

    private WeatherView weatherViewForCity(City city) {
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
            throw new ForecastNotFoundException("Forecast is not found for city ${city?.printName}!")
        }
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

    private static Map<String, String> topCities() {
        if (TOP_SEARCHED_CITIES.size() == 0) {
            City.findAllByIsActiveAndPopulationIsNotNull(true, [max: 3, sort: "population", order: "desc"]).each {
                TOP_SEARCHED_CITIES.put(it.printName, it.urlPart)
            }
        }
        TOP_SEARCHED_CITIES
    }
}
