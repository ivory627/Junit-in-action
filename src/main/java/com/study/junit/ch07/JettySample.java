package com.study.junit.ch07;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class JettySample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ContextHandler root = new ContextHandler(server, "/");
        root.setBaseResourceAsString("./pom.xml");
        root.setHandler(new ResourceHandler());

        server.setStopAtShutdown(true);
        server.start();
    }
}