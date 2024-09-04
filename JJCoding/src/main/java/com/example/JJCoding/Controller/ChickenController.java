package com.example.JJCoding.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChickenController {

    @GetMapping("/chicken")
    public String Chicken(Model model) {
        return "/chicken/chicken";
    }

}
