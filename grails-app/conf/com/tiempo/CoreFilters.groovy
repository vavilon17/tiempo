package com.tiempo

class CoreFilters {

    def filters = {
        admin(controller: 'admin', action: '*') {
            before = {
                /*if (Environment.currentEnvironment != Environment.DEVELOPMENT) {
                    redirect(controller: 'main')
                }*/
                if (session.admin_mode != true) {
                    session.requestedURI = request.contextPath == '/' ? request.forwardURI : request.forwardURI.replaceFirst(request.contextPath, '')
                    redirect(controller: 'auth', action: 'authView')
                    return false
                }
            }
        }

        /*all(controller: '*', action: '*') {
            before = {

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }*/
    }
}
