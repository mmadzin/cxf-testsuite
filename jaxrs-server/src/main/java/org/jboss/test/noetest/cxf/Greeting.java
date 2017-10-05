package org.jboss.test.noetest.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Greeting {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public String getGreeting(@PathParam("name") String name) {
        String greeting = "<!DOCTYPE html>\n<html>\n<body>\n";
        greeting += "  <h1>Don " + name + "...</h1>\n";
        greeting += "  <h1>Don Corleone...</h1>\n";
        greeting += "  <h1>Don " + name + " Corleone...</h1>\n";
        greeting += "</body>\n</html>\n";
        return greeting;
    }
}
