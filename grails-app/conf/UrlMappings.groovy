class UrlMappings {

	static mappings = {

//        "/main/weather/$cityId"(controller: "main", action: "weather")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "main")
        "500"(view:'/error')
	}
}
