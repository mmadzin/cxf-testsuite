/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mm.embedded;

import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcatEx {

    public static void main(String[] args) throws LifecycleException,
            InterruptedException,
            ServletException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(".");

        //Context ctx = tomcat.addWebapp("/clusterbench", "/tmp/server/clusterbench.war");
        Context ctx, ctx2, ctx3;
        ctx = tomcat.addWebapp("/jaxrs-server", "/tmp/cxf-embedded-tomcat-toolset/jaxrs-server.war");
        ctx2 = tomcat.addWebapp("/jaxws-server", "/tmp/cxf-embedded-tomcat-toolset/jaxws-server.war");
        ctx3 = tomcat.addWebapp("/db-servlet", "/tmp/cxf-embedded-tomcat-toolset/db-servlet.war");
        
        //ctx.addServletMapping("/*", "Embedded");

        tomcat.start();
        tomcat.getServer().await();
    }
}
