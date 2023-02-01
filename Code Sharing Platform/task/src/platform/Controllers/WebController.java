package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import platform.Services.Service;

@Controller
public class WebController {

    @Autowired
    Service service;
    @GetMapping(path = "/code")
    public String getCode(Model model){
        model.addAttribute("exCode", service.getCode().getCode())
                .addAttribute("exDate", service.getCode().getDate());
        return "template";
    }

    @GetMapping(path="/code/new")
    public String getNew(){
        return "templateNew";
    }
}
