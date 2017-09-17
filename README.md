# cxf-testsuite

# CXF app compilation
mvn clean package

# Copy it to proper directory
cp target/cxf_app.war /tmp/server/

# Embedded App compilation
mvn clean package

# Embedded App execution (start server)
cd /home/mmadzin/tmp/assignment_4/2017-09-13/EmbeddedTomCXF; JAVA_HOME=/usr/java/latest /home/mmadzin/netbeans-8.2/java/maven/bin/mvn "-Dexec.args=-classpath %classpath com.mm.embedded.EmbeddedTomcatEx" -Dexec.executable=/usr/java/latest/bin/java -Dexec.classpathScope=runtime org.codehaus.mojo:exec-maven-plugin:1.2.1:exec

# CXF client compilation
mvn clean package

# CxfClient execution
java -cp target/CxfClient-1.0-SNAPSHOT.jar com.mm.cxfclient.Main

#Expected output
"Don Corleone"

