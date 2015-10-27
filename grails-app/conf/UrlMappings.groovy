class UrlMappings {

	static mappings = {

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "main")

        "404"(view:'/custom404')
        "500"(view:'/custom500')
	}
}
