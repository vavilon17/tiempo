package com.rest

import grails.plugins.rest.client.RestBuilder


class RestBuilderFactory {

    private static RestBuilder restBuilder

    static RestBuilder provideRestBuilder() {
        if (restBuilder == null) {
            restBuilder = new RestBuilder()
        }
        restBuilder
    }
}
