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
    static final DateTimeFormatter yyyyMMdd_dt_formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
    static final DateTimeFormatter hhmm_dt_formatter = DateTimeFormat.forPattern("hh:mm")
    static final MILLS_IN_HOUR = 1000*60*60

    static String prepareTime(String timeFromWs) {
        if (timeFromWs == '0') {
            return "00:00"
        }
        return timeFromWs.substring(0, timeFromWs.indexOf("00")) + ":00"
    }

    static Timestamp prepareTimestamp(String timeFromWs, Day day) {
        long base = day.date.getTime()
        long offset = 0
        if (timeFromWs != '0') {
            offset = Long.parseLong(timeFromWs.substring(0, timeFromWs.indexOf("00"))) * MILLS_IN_HOUR
        }
        new Timestamp(base + offset)
    }
}
