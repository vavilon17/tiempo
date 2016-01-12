class UrlMappings {

	static mappings = {

        "/robots.txt"                           (controller: 'main', action: 'showRobots')
        "/sitemap.xml"                          (controller: 'main', action: 'showMainSitemap')
        "/googleb092fb8796bb7e18.html"          (controller: 'main', action: 'googleVer')

        "/"                 (controller: "main", action: "weather")
        "/weather"          (controller: "main", action: "weather")
        "/weather/$cityUrl" (controller: "main", action: "weather")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "404"(view:'/custom404')
        "500"(view:'/custom500')
	}
}
