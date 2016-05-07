class UrlMappings {

	static mappings = {

        "/robots.txt"                           (controller: 'main', action: 'showRobots')
        "/sitemap.xml"                          (controller: 'main', action: 'showSitemap')
        "/sitemap-$countryCode?.xml"            (controller: 'main', action: 'showCountrySitemap')

        "/googlea0c97031d7b7720d.html"          (controller: 'main', action: 'googleVer') // ar

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
