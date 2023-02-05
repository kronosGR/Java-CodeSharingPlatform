package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.Services.Service;

@Controller
public class WebController {

    @Autowired
    Service service;

    @GetMapping(path = "/code/{id}")
    public String getCodeById(Model model, @PathVariable long id){
        model.addAttribute("code", service.getCodeById(id));
        return "template";
    }

    @GetMapping(path="/code/new")
    public String getNew(){
        return "templateNew";
    }

    @GetMapping(path="/code/latest")
    public String getLatest(Model model){
        model.addAttribute("latest", service.getLatestCode());
        return "templateLatest";
    }
}
