package nl.woudstra.sample.mvc.controller;

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

    @Autowired
    public HomeController(ServiceExampleImpl serviceExample){
        this.serviceExample = serviceExample;
    }

    @GetMapping
    public String showMessageFromService(ModelMap model){
        model.addAttribute("message", serviceExample.helloWorldServiceOperation("Some random String"));
        return "home";
    }
}
