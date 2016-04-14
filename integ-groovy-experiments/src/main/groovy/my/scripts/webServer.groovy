#!/usr/bin/env groovy
package my.scripts

import groovy.servlet.GroovyServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.servlet.ServletContextHandler

def startJetty() {
    def server = new Server(8080)

    def handler = new ServletContextHandler(ServletContextHandler.SESSIONS)

    handler.contextPath = '/'
    handler.resourceBase = '.'
    handler.addServlet(GroovyServlet, '/scripts/*')

    def filesHolder = handler.addServlet(DefaultServlet, '/')
    filesHolder.setInitParameter('resourceBase', './public')

    server.handler = handler
    server.start()
}

println "Starting Jetty, press CTRL+C to stop."
startJetty()