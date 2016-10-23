package nl.woudstra.sample;

import nl.woudstra.sample.config.SoapConfig;
import nl.woudstra.sample.config.WebConfig;
import nl.woudstra.sample.services.soap.server.ServiceExampleImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by bouke on 23-10-16.
 */
@Configuration
@ComponentScan
@Import({SoapConfig.class, WebConfig.class})
public class Application {

}
