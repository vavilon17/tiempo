package com.util

import com.tiempo.wwo.Day
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

import java.sql.Timestamp
import java.text.SimpleDateFormat

/**
 * Created by vit on 18.07.2015.
 */
class DataUtils {

    static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd")
    static final SimpleDateFormat yyyyMMdd_hhmm_a = new SimpleDateFormat("yyyy-MM-dd hh:mm a")
    static final DateTimeFormatter yyyyMMdd_dt_formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
    static final DateTimeFormatter hhmm_dt_formatter = DateTimeFormat.forPattern("hh:mm")
    static final MILLS_IN_HOUR = 1000*60*60

    static String prepareTime(String timeFromWs) {
        if (timeFromWs == '0') {
            return "00:00"
        }
        return timeFromWs.substring(0, timeFromWs.indexOf("00")) + ":00"
    }

    static Timestamp prepareDayTimestamp(String timeFromWs, Day day) {
        long base = day.date.getTime()
        long offset = 0
        if (timeFromWs != '0') {
            offset = Long.parseLong(timeFromWs.substring(0, timeFromWs.indexOf("00"))) * MILLS_IN_HOUR
        }
        new Timestamp(base + offset)
    }

    static float weightedFloatAverage(float first, float second, double delta, int precision) {
        int factor = (int) Math.pow(10, precision)
        (float) Math.round(weightedAverage(first, second, delta) * factor) / factor
    }

    static int weightedIntAverage(int first, int second, double delta) {
        Math.round(weightedAverage(first, second, delta))
    }

    private static def weightedAverage(def first, def second, double delta) {
        if (first == second) {
            return first
        }
        (double) (first + (delta * (double) (second - first)))
    }
}
