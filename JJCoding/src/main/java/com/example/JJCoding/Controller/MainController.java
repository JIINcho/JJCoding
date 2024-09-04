package com.example.JJCoding.Controller;

import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class MainController {


    /*메인페이지(수정_테스트)*/
    @GetMapping("/")
    public String Main(Model model) {
        return "/main/main";
    }

}
