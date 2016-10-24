# spring-java-config-apache-cxf
Sample project for configuring Apache CXF with Java config without Spring boot.

This project shows how to use a web.xml and startup a Spring context that is completely shared between CXFServlet
(for SOAP services) and the DispatcherServlet (for Spring MVC). This is usefull for autowiring the database layer
to the SOAP services for example.

All Spring configuration (including CXF parts) is done with Java annotations.

The project is created in Intellij, but you should easily be able to import the pom.xml as it is just another Maven project.
To solve some missing classes, you should run a `mvn clean install` in order to generate the classed based on the WSDL.

After deploying the WAR file in Tomcat (port 8080 is assumed), you can access the following URL's:
* http://localhost:8080/example/ : it shows the mvc endpoint.
* http://localhost:8080/example/services/helloWorld?wsdl : it shows the WSDL.