package com.tiempo

import grails.util.Environment

class CoreFilters {

    def filters = {
        admin(controller: 'admin', action: '*') {
            before = {
                if (Environment.currentEnvironment != Environment.DEVELOPMENT) {
                    redirect(controller: 'main')
                }
            }
        }

        all(controller: '*', action: '*') {
            before = {

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
