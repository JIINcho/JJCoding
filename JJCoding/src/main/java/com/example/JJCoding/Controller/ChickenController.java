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

//    //부모님 회원가입 성공
//    @PostMapping("/parentsSave")
//    public String chickSave(Model model) {
//        System.out.println("parentsDTO = " + parentsDTO);
//        parentsService.save(parentsDTO);
//        return "/chick/myinfo"; //회원가입 html 이름
//    }
//
//    //부모님 로그인 성공
//    @PostMapping("/parentsSuccess")
//    public String chickSuccess(Model model) {
//        ParentsDTO loginResult = parentsService.login(parentsDTO);
//        return "/chick/myinfo";
//    }

}
