package com.tiempo

class AuthController {

    def index() {}

    def authView() {
    }

    def login(String pass) {
        if (pass && pass == "curiosity") {
            session.admin_mode = true
            log.info("requested uri - ${session.requestedURI}")
            redirect(uri: session.requestedURI)
        } else {
            flash.message = "Incorrect!"
            render(view: 'authView')
        }
    }
}
