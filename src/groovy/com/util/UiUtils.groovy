package com.util

import com.tiempo.WeatherType

import static com.tiempo.WeatherType.*

class UiUtils {

    public static String provideIconClass(WeatherType weatherType) {
        switch (weatherType) {
            case CLOUD_BIG_RAIN:
                return "icon_1"
            case CLOUD_LIGHTNING:
                return "icon_2"
            case CLOUD_MIST:
                return "icon_3"
            case SUN:
                return "icon_4"
            case CLOUD_MIST_WET:
                return "icon_5"
            case SNOW:
                return "icon_6"
            case CLOUD:
                return "icon_7"
            case CLOUD_RAIN:
                return "icon_8"
            case SUN_CLOUD_RAIN:
                return "icon_9"
            case SUN_CLOUD:
                return "icon_10"
            case MOON:
                return "icon_11"
            case MOON_CLOUD_RAIN:
                return "icon_12"
            case MOON_CLOUD:
                return "icon_13"
        }
    }

    // todo cache this
    public static String dayOfWeekShortName(Date date) {
        Calendar c = Calendar.getInstance()
        c.setTime(date)
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
        switch (dayOfWeek) {
            case 1:
                return "Do"
            case 2:
                return "Lu"
            case 3:
                return "Ma"
            case 4:
                return "Mi"
            case 5:
                return "Ju"
            case 6:
                return "Vi"
            case 7:
                return "Sa"
        }
        return ""
    }
}
