class UrlMappings {

	static mappings = {

        "/robots.txt"                           (controller: 'main', action: 'showRobots')
        "/sitemap.xml"                          (controller: 'main', action: 'showSitemap')

        "/googleb092fb8796bb7e18.html"          (controller: 'main', action: 'googleVer') // ar
        "/googlec4ec2d182d1725b9.html"          (controller: 'main', action: 'googleVer2') // uy, py, cl

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
