package com.example.JJCoding.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChickController {

    /*테스트 수정?=*/
    @GetMapping("/chick")
    public String Chick(Model model) {
        return "/chick/chick";
    }

    @GetMapping("/chickinfo")
    public String teacherinfo(Model model) {
        return "/chick/teacherinfo";
    }

    @GetMapping("/infocheck")
    public String infocheck(Model model) {
        return "/chick/infocheck";
    }

    @GetMapping("/myinfo")
    public String myinfo(Model model) {
        return "/chick/myinfo";
    }

    @GetMapping("/addkinder")
    public String addkinder(Model model) {
        return "/chick/addkinder";
    }

}
