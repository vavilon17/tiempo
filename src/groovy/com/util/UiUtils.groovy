package com.util

import com.tiempo.WeatherType

import static com.tiempo.WeatherType.*

class UiUtils {

    public static String provideIconClassBig(WeatherType weatherType) {
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
        return provideIconClassBig(CLOUD)
    }

    public static String provideIconClassSmall(WeatherType weatherType) {
        switch (weatherType) {
            case SUN_CLOUD:
                return "icon_1"
            case SUN:
                return "icon_2"
            case SUN_CLOUD_RAIN:
                return "icon_3"
            case CLOUD:
                return "icon_4"
            case CLOUD_RAIN:
                return "icon_5"
            case SNOW:
                return "icon_6"
            case CLOUD_MIST_WET:
                return "icon_7"
            case CLOUD_BIG_RAIN:
                return "icon_8"
            case CLOUD_MIST:
                return "icon_9"
            case CLOUD_LIGHTNING:
                return "icon_10"
            case MOON_CLOUD:
                return "icon_11"
            case MOON:
                return "icon_12"
            case MOON_CLOUD_RAIN:
                return "icon_13"
        }
    }

    public static String provideIconClassForecastDay(WeatherType weatherType) {
        switch (weatherType) {
            case SUN_CLOUD:
                return "icon_1"
            case SUN:
                return "icon_2"
            case SUN_CLOUD_RAIN:
                return "icon_3"
            case CLOUD:
                return "icon_4"
            case CLOUD_RAIN:
                return "icon_5"
            case SNOW:
                return "icon_6"
            case CLOUD_MIST_WET:
                return "icon_7"
            case CLOUD_BIG_RAIN:
                return "icon_8"
            case CLOUD_MIST:
                return "icon_9"
            case CLOUD_LIGHTNING:
                return "icon_10"
        }
        return provideIconClassForecastDay(CLOUD)
    }

    public static String provideIconClassForecastNight(WeatherType weatherType) {
        switch (weatherType) {
            case MOON_CLOUD:
                return "icon_1"
            case MOON:
                return "icon_2"
            case MOON_CLOUD_RAIN:
                return "icon_3"
            case CLOUD:
                return "icon_4"
            case CLOUD_RAIN:
                return "icon_5"
            case SNOW:
                return "icon_6"
            case CLOUD_MIST_WET:
                return "icon_7"
            case CLOUD_BIG_RAIN:
                return "icon_8"
            case CLOUD_MIST:
                return "icon_9"
            case CLOUD_LIGHTNING:
                return "icon_10"
        }
        return provideIconClassForecastNight(MOON_CLOUD)
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

    // todo cache this
    public static String dayOfWeekFullName(Date date) {
        Calendar c = Calendar.getInstance()
        c.setTime(date)
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
        switch (dayOfWeek) {
            case 1:
                return "Domingo"
            case 2:
                return "Lunes"
            case 3:
                return "Martes"
            case 4:
                return "Miercoles"
            case 5:
                return "Jueves"
            case 6:
                return "Viernes"
            case 7:
                return "Sabado"
        }
        return ""
    }

    // todo cache this
    public static int dayOfMonth(Date date) {
        Calendar c = Calendar.getInstance()
        c.setTime(date)
        c.get(Calendar.DAY_OF_MONTH)
    }

    // todo cache this
    public static String monthShort(Date date) {
        Calendar c = Calendar.getInstance()
        c.setTime(date)
        int month = c.get(Calendar.MONTH)
        switch (month) {
            case 0:
                return "enero"
            case 1:
                return "feb"
            case 2:
                return "marzo"
            case 3:
                return "abr"
            case 4:
                return "mayo"
            case 5:
                return "jun"
            case 6:
                return "jul"
            case 7:
                return "agosto"
            case 8:
                return "sept"
            case 9:
                return "oct"
            case 10:
                return "nov"
            case 11:
                return "dec"
        }
        ""
    }

    public static String capitalizeFirstLetter(String original){
        if(original.length() == 0) {
            return original;
        }
        original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}
