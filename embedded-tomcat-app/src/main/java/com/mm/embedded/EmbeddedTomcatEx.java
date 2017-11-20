/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mm.embedded;

import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.coyote.http2.Http2Protocol;
import org.apache.tomcat.util.net.SSLHostConfig;

public class EmbeddedTomcatEx {

    public static void main(String[] args) throws LifecycleException,
            InterruptedException,
            ServletException {

        Tomcat tomcat = new Tomcat();
        Service service = tomcat.getService();
        //Create SSL connector
        service.addConnector(EmbeddedTomcatEx.getSslConnector());
        service.addLifecycleListener(getAprListener());
        
//        tomcat.setPort(8080);
        tomcat.setBaseDir(".");
        
        //Context ctx = tomcat.addWebapp("/clusterbench", "/tmp/server/clusterbench.war");
        Context ctx, ctx2;
        ctx = tomcat.addWebapp("/jaxrs-server", "/tmp/cxf-embedded-tomcat-toolset/jaxrs-server.war");
        ctx2 = tomcat.addWebapp("/jaxws-server", "/tmp/cxf-embedded-tomcat-toolset/jaxws-server.war");
        
        //ctx.addServletMapping("/*", "Embedded");

        tomcat.start();
        tomcat.getServer().await();
    }
    
    private static Connector getSslConnector() {
        Connector con = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        con.setPort(8443);
        
        Http11NioProtocol protocol = (Http11NioProtocol) con.getProtocolHandler();
        protocol.setSSLEnabled(true);
        protocol.setMaxThreads(150);
        protocol.setSslImplementationName("org.apache.tomcat.util.net.openssl.OpenSSLImplementation");
        
        Http2Protocol http2 = new Http2Protocol();
        con.addUpgradeProtocol(http2);
        
        SSLHostConfig sslConf = new SSLHostConfig();
        sslConf.setTruststoreFile("conf/cacerts");
        sslConf.setTruststorePassword("");
        sslConf.setCertificateVerification("optional");
        sslConf.setCertificateKeystoreFile("conf/tomcat_keystore.jks");
        sslConf.setCertificateKeystorePassword("tomcat");
        sslConf.setCertificateKeystoreType("RSA");
        
        con.addSslHostConfig(sslConf);
        
        return con;
    }

    private static LifecycleListener getAprListener(){
        AprLifecycleListener apr = new AprLifecycleListener();
        apr.setUseOpenSSL(true);

        return apr;
    }
}
