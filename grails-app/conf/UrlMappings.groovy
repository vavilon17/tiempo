class UrlMappings {

	static mappings = {

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"                 (controller: "main")
        "/weather/$cityUrl" (controller: "main", action: "weather")

        "404"(view:'/custom404')
        "500"(view:'/custom500')
	}
}
