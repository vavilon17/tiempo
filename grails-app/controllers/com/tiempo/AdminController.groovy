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

    def fillGeoData() {
        //geoDataService.importRegionsFromFile_Geodata("d:\\download\\AR\\reg.csv")
        geoDataService.importCitiesFromFile_Geodata("d:\\download\\AR\\AR_actual.csv")
        //geoDataService.fillGeoData("AR")
    }

    def dist() {
        geoDataService.setCityRelationsInsideSameWeatherRegion()
    }
}
