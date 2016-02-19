package com.tiempo.last

import org.apache.log4j.Logger


class WeatherImportSecJob {

    private static final Logger logger = Logger.getLogger(WeatherImportFirstJob.class)

    static triggers = {
        cron name: 'secondImport', cronExpression: '0 0 1 * * ?'
    }

    def importService

    def execute() {
        long start = System.currentTimeMillis()
        logger.info("*** IMPORT JOB [1500-2500] STARTED")
        importService.runForecastImport(1500, 1000)
        logger.info("*** IMPORT JOB [1500-2500] FINISHED. Duration: ${Math.round((System.currentTimeMillis() - start)/(1000 * 60))} mins.")
    }
}
