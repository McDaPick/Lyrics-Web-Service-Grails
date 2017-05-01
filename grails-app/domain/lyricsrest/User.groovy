package lyricsrest

import javax.annotation.Resource
import javax.annotation.Resources
import grails.rest.*

@grails.rest.Resource(uri='/users')
class User {
    int id
    String username
    String password
    String song
    String column

    static constraints = {
        id blank:false
        username blank: false
        password blank: false
        song blank: false
    }
}
