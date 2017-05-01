package lyricsrest

class BootStrap {

    def init = { servletContext ->
        new User(id: 1, username: "mnielsen", password: "kickflip", song: "My Heroine").save()
        new User(id: 2, username: "chenriquez", password: "heelflip", song:"Bittersweet").save()
    }
    def destroy = {
    }
}
