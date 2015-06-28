package com.tiempo

class Config {

    String key
    String value

    static mapping = {
        key index: 'config_key_idx'
    }

    static constraints = {
        value nullable: true
    }
}
