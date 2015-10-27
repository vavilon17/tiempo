package com.tiempo.last

import org.apache.log4j.Logger

/**
 * Created by yaskalv on 10.06.2015.
 */
class WeatherImportJob {

    private static final Logger logger = Logger.getLogger(WeatherImportJob.class)

    static triggers = {
        cron name: 'everyNight', cronExpression: '0 1 0 * * ?'
//        simple name: 'runAfterStart', startDelay: 60000, repeatInterval: 86400000L
    }

    def importService

    def execute() {
        long start = System.currentTimeMillis()
        logger.info("*** IMPORT JOB STARTED")
        int countItems = importService.runForecastImport()
        logger.info("*** IMPORT JOB FINISHED. Items processed: ${countItems}. Duration: ${Math.round((System.currentTimeMillis() - start)/(1000 * 60))} mins.")
    }
}
