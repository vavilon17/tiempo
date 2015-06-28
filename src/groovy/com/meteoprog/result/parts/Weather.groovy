package com.meteoprog.result.parts

/**
 * Created by vit on 14.03.2015.
 */
class Weather {
    String city_id
    String url
    String name
    float lat
    float lon
    float height
    Object vmo
    Integer offset
    Map<String, ForecastBody> weather
}
