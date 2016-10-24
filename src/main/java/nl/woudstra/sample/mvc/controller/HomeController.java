package nl.woudstra.sample.mvc.controller;

import nl.woudstra.sample.services.soap.client.ClientExampleImpl;
import nl.woudstra.sample.services.soap.server.ServiceExampleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bouke on 23-10-16.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private ServiceExampleImpl serviceExample;
    private ClientExampleImpl clientExample;

    @Autowired
    public HomeController(ServiceExampleImpl serviceExample, ClientExampleImpl clientExample){
        this.serviceExample = serviceExample;
        this.clientExample = clientExample;
    }

    @GetMapping
    public String showMessageFromService(ModelMap model){
        // First get the message from the service directly (no SOAP involved)
        model.addAttribute("messageServer", serviceExample.helloWorldServiceOperation("server"));

        // Then get the message through the SOAP protocol
        model.addAttribute("messageClient", clientExample.getMessage("client"));
        return "home";
    }
}
