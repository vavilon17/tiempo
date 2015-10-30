class BootStrap {

    def cacheService

    def init = { servletContext ->
        cacheService.fillCache()
    }

    def destroy = {
    }
}
