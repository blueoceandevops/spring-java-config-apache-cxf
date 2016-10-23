package nl.woudstra.sample.config;

import nl.woudstra.sample.services.soap.server.ServiceExampleImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by bouke on 23-10-16.
 */
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class SoapConfig {

    @Autowired
    private Bus cxfbus; // use a private variable since it can be reused for multiple services

    @Bean
    @Autowired
    public EndpointImpl endpointForSoapService(ServiceExampleImpl serviceExampleImpl){
        EndpointImpl endpoint = new EndpointImpl(cxfbus, serviceExampleImpl);
        endpoint.publish("helloWorld");
        return endpoint;
    }
}
