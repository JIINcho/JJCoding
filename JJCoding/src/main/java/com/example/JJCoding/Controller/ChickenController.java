package com.example.JJCoding.Controller;

import ch.qos.logback.core.model.Model;
import com.example.JJCoding.DTO.ParentsDTO;
import com.example.JJCoding.DTO.TeacherDTO;
import com.example.JJCoding.Service.ParentsService;
import com.example.JJCoding.Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChickenController {

    private ParentsService parentsService;
    private ParentsDTO parentsDTO;

    @GetMapping("/chicken")
    public String Chicken(Model model) {
        return "/chicken/chicken";
    }

    @GetMapping("/chickeninfo")
    public String ChickenInfo(Model model) {
        return "/chicken/p_info";
    }

}
