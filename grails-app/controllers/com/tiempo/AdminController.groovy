package com.tiempo

class AdminController {

    def geoDataService
    def importService

    def index() {}

    def fillGeoData(String country) {
        geoDataService.importAndSetupGeoData(country)
    }

    def fillCache() {
        geoDataService.fillCachedData()
    }

    def runImport() {
        log.info("Run import")
        importService.runForecastImport()
    }
}
