package com.tiempo

class AdminController {

    def geoDataService
    def importService
    def cacheService

    def index() {}

    def fillGeoData(String country) {
        geoDataService.importAndSetupGeoData(country)
    }

    def fillCache() {
        cacheService.fillCache()
    }

    def runImport() {
        log.info("Run import")
        importService.runForecastImport()
    }
}
