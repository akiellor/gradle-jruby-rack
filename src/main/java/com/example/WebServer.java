package com.example;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.ProtectionDomain;
import java.security.SecureRandom;

public class WebServer {
    public static void main(String[] args){
        Server server = new Server(8080);

        ProtectionDomain domain = WebServer.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        HandlerCollection handlers = new HandlerCollection();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
        webapp.setServer(server);
        webapp.setWar(location.toExternalForm());
        server.setHandler(handlers);

        try {
            server.setStopAtShutdown(true);
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
