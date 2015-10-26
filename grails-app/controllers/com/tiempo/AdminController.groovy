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
        geoDataService.importAndSetupGeoData(country)
    }
}
