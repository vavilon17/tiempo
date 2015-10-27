class BootStrap {

    def geoDataService

    def init = { servletContext ->
        geoDataService.fillCachedData()
    }

    def destroy = {
    }
}
