package com.dto.ui

import com.tiempo.City
import com.tiempo.wwo.Day
import com.tiempo.wwo.Hourly


class WeatherView {
    City city
    Hourly current
    List<Hourly> todayHourlyList
    List<Day> forecast
    int halfDayPercent

    byte todayMaxDay
    byte todayMinNight

    Map<String, Long> topCities
}
