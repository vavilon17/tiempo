class UrlMappings {

	static mappings = {

        "/robots.txt"                           (controller: 'main', action: 'showRobots')
        "/sitemap.xml"                          (controller: 'main', action: 'showMainSitemap')
        "/sitemap-$countryCode-weather.xml"     (controller: 'main', action: 'showCountrySitemap')

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
