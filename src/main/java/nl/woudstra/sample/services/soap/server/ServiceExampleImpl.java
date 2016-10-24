package nl.woudstra.sample.services.soap.server;


import nl.woudstra.helloworldservice.HelloWorldServicePortType;
import nl.woudstra.sample.database.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;

/**
 * Created by bouke on 23-10-16.
 */

@javax.jws.WebService(
        serviceName = "HelloWorldService",
        portName = "HelloWorldServicePort",
        targetNamespace = "http://www.woudstra.nl/HelloWorldService/",
        wsdlLocation = "classpath:/wsdl/helloWorld/HelloService.wsdl",
        endpointInterface = "nl.woudstra.helloworldservice.HelloWorldServicePortType")
@Service
public class ServiceExampleImpl implements HelloWorldServicePortType {

    private MessageRepository repository;

    @Autowired
    public ServiceExampleImpl(MessageRepository repository){
        this.repository = repository;
    }

    @Override
    public String helloWorldServiceOperation(@WebParam(name = "in", targetNamespace = "") String in) {
        return repository.getMessage() + " from " + in;
    }
}
