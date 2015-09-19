class UrlMappings {

	static mappings = {


//        "/weather" controller: 'main', action: 'weather'
//        "/weather/${cityId}" (controller: "main", action: "weather")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(controller: "main")

        "404"(view:'/custom404')
        "500"(view:'/custom500')
	}
}
