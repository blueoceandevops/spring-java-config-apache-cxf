package nl.woudstra.sample.services.soap.client;

import nl.woudstra.helloworldservice.HelloWorldService;
import nl.woudstra.helloworldservice.HelloWorldServicePortType;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * Created by bouke on 24-10-16.
 */
@Service
public class ClientExampleImpl {

    public String getMessage(String input){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloWorldServicePortType.class);
        factory.setAddress("http://localhost:8080/example/services/helloWorld");
        HelloWorldServicePortType servicePort = (HelloWorldServicePortType) factory.create();
        return servicePort.helloWorldServiceOperation(input);
    }
}
