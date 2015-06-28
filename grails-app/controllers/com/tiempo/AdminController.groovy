package com.tiempo

class AdminController {

    def restBridgeService

    def index() {}

    def fillData() {
        restBridgeService.syncData()
    }

    def fillCoord() {
        restBridgeService.fillCoordinates()
    }
}
