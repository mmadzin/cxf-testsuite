Welcome to demo toolset which contains embedded tomcat app and web service apps (SOAP, RESTful).


Applications:
  - embedded-tomcat-app
  - jaxrs-server
  - jaxrs-client
  - jaxws-server
  - jaxws-client


Compilation: 
In the root directory run: 

$ mvn clean package 


Demo execution: 
Embedded-tomcat-app contains embedded tomcat server and deploys jaxrs-server jaxws-server. To test a service just run a client app (jaxrs-client or jaxws-client).

Copy wars to /tmp/cxf-embedded-tomcat-toolset
$ mkdir /tmp/cxf-embedded-tomcat-toolset
$ cp jaxrs-server/target/jaxrs-server.war /tmp/cxf-embedded-tomcat-toolset
$ cp jaxws-server/target/jaxws-server.war /tmp/cxf-embedded-tomcat-toolset

Start server:
$ cd embedded-tomcat-app
$ java -jar target/embedded-tomcat-app.jar

JAXRS client execution:
$ java -jar jaxrs-client/target/jaxrs-client.jar

Expected output: 
<!DOCTYPE html>
<html>
<body>
  <h1>Don Vincenzo...</h1>
  <h1>Don Corleone...</h1>
  <h1>Don Vincenzo Corleone...</h1>
</body>
</html>

JAXWS Client execution:
$ java -jar jaxws-client/target/jaxws-client.jar

Expected output:
Don Vincenzo

