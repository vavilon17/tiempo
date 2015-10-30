package com.tiempo

class CoreFilters {

    def filters = {
        country(controller: '*', action: '*') {
            before = {
                if (!session?.country) {
                    session.country = request.getHeader("GEOIP_COUNTRY_CODE")
                }
            }
        }

        admin(controller: 'admin', action: '*') {
            before = {
                if (session.admin_mode != true) {
                    session.requestedURI = request.contextPath == '/' ? request.forwardURI : request.forwardURI.replaceFirst(request.contextPath, '')
                    redirect(controller: 'auth', action: 'authView')
                    return false
                }
            }
        }
    }
}
