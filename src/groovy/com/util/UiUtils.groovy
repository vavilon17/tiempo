package com.util

import com.tiempo.WeatherType

import static com.tiempo.WeatherType.CLOUD
import static com.tiempo.WeatherType.CLOUD_BIG_RAIN
import static com.tiempo.WeatherType.CLOUD_LIGHTNING
import static com.tiempo.WeatherType.CLOUD_MIST
import static com.tiempo.WeatherType.CLOUD_MIST_WET
import static com.tiempo.WeatherType.CLOUD_RAIN
import static com.tiempo.WeatherType.MOON
import static com.tiempo.WeatherType.MOON_CLOUD
import static com.tiempo.WeatherType.MOON_CLOUD_RAIN
import static com.tiempo.WeatherType.SNOW
import static com.tiempo.WeatherType.SUN
import static com.tiempo.WeatherType.SUN_CLOUD
import static com.tiempo.WeatherType.SUN_CLOUD_RAIN


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
}
