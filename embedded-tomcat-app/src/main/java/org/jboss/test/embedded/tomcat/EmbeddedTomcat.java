/*
 * Copyright 2017 Matus Madzin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.test.embedded.tomcat;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author mmadzin
 */
public class EmbeddedTomcat {
    private Tomcat tomcat;
    private Context ctx;
    
    /**
     * Creates new embedded tomcat
     * 
     * @param port - where server will listen
     * @param workspace - for directory with temporary files
     */
    public EmbeddedTomcat(int port, String workspace) {
        this.tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(workspace + File.separator + "tomcat." + port);
    }
    
    /**
     * Adds application for deployment
     * 
     * @param contextPath - where application will be deployed
     * @param app - absolute path to application (with application name)
     * @throws javax.servlet.ServletException
     */
    public void deploy(String contextPath, String app) throws ServletException {
        this.ctx = tomcat.addWebapp(contextPath, app);
    }
    
    /**
     * Starts tomcat
     * 
     * @throws LifecycleException
     */
    public void start() throws LifecycleException {
        this.tomcat.start();
    }
    
    public void stop() throws LifecycleException {
        this.tomcat.stop();
    }
    
    public void destroy() throws LifecycleException {
        this.tomcat.destroy();
    }
}
