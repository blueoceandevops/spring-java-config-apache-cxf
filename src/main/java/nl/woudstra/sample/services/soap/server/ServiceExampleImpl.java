package nl.woudstra.sample.services.soap.server;

import com.teknocrat.webserviceone.WebServiceOnePortType;
import nl.woudstra.sample.database.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebParam;

/**
 * Created by bouke on 23-10-16.
 */
@javax.jws.WebService(
        serviceName = "WebServiceOne",
        portName = "WebServiceOnePort",
        targetNamespace = "http://www.teknocrat.com/WebServiceOne/",
        endpointInterface = "com.teknocrat.webserviceone.WebServiceOnePortType")
@Service
public class ServiceExampleImpl implements WebServiceOnePortType {

    private MessageRepository repository;

    @Autowired
    public ServiceExampleImpl(MessageRepository repository){
        this.repository = repository;
    }

    @Override
    public String webServiceOneOperation(@WebParam(name = "in", targetNamespace = "") String in) {
        return repository.getMessage();
    }
}
