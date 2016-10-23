package nl.woudstra.sample;

import nl.woudstra.sample.services.soap.server.ServiceExampleImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by bouke on 23-10-16.
 */
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@EnableWebMvc
@ComponentScan
public class Application implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Autowired
    private Bus cxfbus;

    @Autowired
    private ServiceExampleImpl serviceExampleImpl;

    @Bean
    public EndpointImpl endpointForSoapService(){
        EndpointImpl endpoint = new EndpointImpl(cxfbus, serviceExampleImpl);
        endpoint.publish("helloWorld");
        return endpoint;
    }
}
