package org.jboss.noetest.cxf;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.jboss.test.embedded.tomcat.EmbeddedTomcat;
import org.jboss.test.testsuite.greetingrestfulclientapp.Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mmadzin
 */
public class CxfWithEmbeddedTomcatTest {

    static int PORT = 8080;
    static String ADDRESS = "localhost";
    
    public static void main(String args[]) throws MalformedURLException, URISyntaxException {

        EmbeddedTomcat server = new EmbeddedTomcat(PORT, "/tmp/embd");
        Client client = new Client();
        
        try {
            server.deploy("/", "/tmp/emdb/jaxrs-server.war");
            server.start();
            
            URL url = new URL("http", ADDRESS, PORT, "/jaxrs-server/greeting/Vincenzo");
            URI uri = url.toURI();
            
            
            try(CloseableHttpClient httpClient = TestHttpClientUtils.promiscuousCookieHttpClient()){
                HttpResponse response = null;
                
                response = httpClient.execute(new HttpGet(uri))
            }
            client.sendRequest(PORT);
            
        } catch (ServletException ex) {
            Logger.getLogger(CxfWithEmbeddedTomcatTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LifecycleException ex) {
            Logger.getLogger(CxfWithEmbeddedTomcatTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
