package com.tiempo.last

import org.apache.log4j.Logger


class WeatherImportThirdJob {

    private static final Logger logger = Logger.getLogger(WeatherImportFirstJob.class)

    static triggers = {
        cron name: 'thirdImport', cronExpression: '0 0 2 * * ?'
    }

    def importService

    def execute() {
        long start = System.currentTimeMillis()
        logger.info("*** IMPORT JOB [2500-3500] STARTED")
        importService.runForecastImport(2500, 1000)
        logger.info("*** IMPORT JOB [2500-3500] FINISHED. Duration: ${Math.round((System.currentTimeMillis() - start)/(1000 * 60))} mins.")
    }
}
