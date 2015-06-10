package com.tiempo

/**
 * Created by yaskalv on 10.06.2015.
 */
class WeatherImportJob {

    static triggers = {
//        cron name: 'everyNight', cronExpression: '0 1 0 * * ?'
//        simple name: 'runAfterStart', startDelay: 60000, repeatInterval: 86400000L
    }

    def importService

    def execute() {
        importService.runForecastImport()
    }
}
