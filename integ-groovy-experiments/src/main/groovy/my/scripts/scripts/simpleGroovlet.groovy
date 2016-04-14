package my.scripts.scripts

if (!session) {
    session = request.getSession(true)
}

if (!session.hasProperty("counter")) {
    session["counter"] = 1
}

html.html {
    head {
        title 'Simple Groovlet'
    }
    body {
        h1 'Welcome to my Groovlet'
        p "The current time at this server is ${new Date()}"
        p "The session counter is now at ${session}"
//        p "The session counter is now at ${session.counter}"
        br()
        p "System properties:"
        ul {
            for ( String prop in System.properties.keySet()) {
                li "$prop: ${System.getProperty(prop)}"
            }
        }
    }
}

//session.counter += 1
