Welcome to demo toolset which contains embedded tomcat app and web service app (RESTful).

### Applications:
  - embedded-tomcat-app
  - jaxrs-server
  - jaxrs-client
  - jaxws-server
  - jaxws-client

### Requirements:
  - tomcat-native


### Compilation:   
In the root directory run:   

~~~
$ mvn clean package
~~~

Recommend to use local repository by using parameter `-Dmaven.repo.local=<maven.repository.location>`

### Demo execution (HTTPS):   
Embedded-tomcat-app contains embedded tomcat server and deploys jaxrs-server. 

1) Copy war to /tmp/cxf-embedded-tomcat-toolset
~~~
$ mkdir /tmp/cxf-embedded-tomcat-toolset  
$ cp jaxrs-server/target/jaxrs-server.war /tmp/cxf-embedded-tomcat-toolset  
~~~

Alternatively, you can choose the `tmp` location by using `java.io.tmp` variable; for example: `java -Djava.io.tmpdir=/mytempdir jar ...`.

2) Start server:
~~~
$ cd embedded-tomcat-app
$ mkdir tomcat.8080
$ mkdir tomcat.8080/webapps
$ java -jar target/embedded-tomcat-app.jar
~~~

3) To test a service just open your browser and go to https://localhost:8443/jaxrs-server/greeting/Vincenzo  

Expected output:
~~~
<!DOCTYPE html>  
<html>  
<body>  
  <h1>Don Vincenzo...</h1>  
  <h1>Don Corleone...</h1>  
  <h1>Don Vincenzo Corleone...</h1>  
</body>  
</html>  
~~~
