package com.tiempo

class AdminController {

    def restBridgeService
    def geoDataService

    def index() {}

    def fillData() {
        restBridgeService.syncData()
    }

    def fillCoord() {
        restBridgeService.fillCoordinates()
    }

    def fillGeoData(String country) {
        geoDataService.importRegionsFromFile_Geodata(country)
        geoDataService.importCitiesFromFile_Geodata(country)
        geoDataService.setupCoreImportedCities()
    }

    def dist() {
        geoDataService.setCityRelationsInsideSameWeatherRegion()
    }
}
