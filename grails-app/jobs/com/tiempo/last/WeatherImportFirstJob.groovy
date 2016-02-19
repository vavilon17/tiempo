package com.tiempo.last

import org.apache.log4j.Logger

/**
 * Created by yaskalv on 10.06.2015.
 */
class WeatherImportFirstJob {

    private static final Logger logger = Logger.getLogger(WeatherImportFirstJob.class)

    static triggers = {
        cron name: 'firstImport', cronExpression: '0 0 0 * * ?'
    }

    def importService

    def execute() {
        long start = System.currentTimeMillis()
        logger.info("*** IMPORT JOB [0-1500] STARTED")
        importService.runForecastImport(0, 1500)
        logger.info("*** IMPORT JOB [0-1500] FINISHED. Duration: ${Math.round((System.currentTimeMillis() - start)/(1000 * 60))} mins.")
    }
}
