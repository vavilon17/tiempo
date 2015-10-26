package com.rest.wwo_import


class UrlProvider {

    String baseUrl
    String key
    String numOfDays

    String cachedUrlBase = ""

    String provideUrlBase() {
        if (!cachedUrlBase) {
            cachedUrlBase = new StringBuilder(baseUrl).append("?").append("format=json&tp=3&extra=isDayTime&cc=no&mca=no")
                    .append("&key=").append(key)
                    .append("&num_of_days=").append(numOfDays)
            .toString()
        }
        cachedUrlBase
    }

}
