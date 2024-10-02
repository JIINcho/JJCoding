package com.example.JJCoding.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.example.JJCoding.DTO.TeacherDTO;
import com.example.JJCoding.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ChickController {

    @Autowired
    private TeacherService teacherService;
    private TeacherDTO teacherDTO;

    @GetMapping("/chick")
    public String Chick(Model model) {
        return "/chick/teachermain";
    }

    //회원가입페이지
    @GetMapping("/chick/sign")
    public String sign(Model model) {
        model.addAttribute("teacherDTO", new TeacherDTO());
        return "/chick/teachersignin";
    }

    //회원가입페이지2
    @GetMapping("/chick/sign2")
    public String sign2(HttpSession session, Model model) {
        TeacherDTO teacherDTO = (TeacherDTO) session.getAttribute("teacherDTO");
        if (teacherDTO == null) {
            return "redirect:/chick/sign";
        }
        model.addAttribute("teacherDTO", teacherDTO);
        return "/chick/teacherinfo";
    }

    //회원정보 받아오기1
    @PostMapping("/teacherSave1")
    public String teacherSave1(@ModelAttribute("teacherDTO") TeacherDTO teacherDTO, HttpSession session) {
        session.setAttribute("teacherDTO", teacherDTO);
        return "redirect:/chick/sign2";
    }

    //선생님 회원가입 성공
    @PostMapping("/teacherSave")
    public String teacherSave(@ModelAttribute("teacherDTO") TeacherDTO teacherDTO, HttpSession session) {
        TeacherDTO sessionTeacherDTO = (TeacherDTO) session.getAttribute("teacherDTO");
        if(sessionTeacherDTO == null) {
            return "redirect:/chick/sign";
        }

        sessionTeacherDTO.setTeacherName(teacherDTO.getTeacherName());
        sessionTeacherDTO.setTeacherGender(teacherDTO.getTeacherGender());
        sessionTeacherDTO.setTeacherPhoneNumber(teacherDTO.getTeacherPhoneNumber());

        teacherService.save(teacherDTO);
        System.out.println("teacherDTO"+teacherDTO);
        return "redirect:/chick/login";
    }


    //로그인페이지
    @GetMapping("/chick/login")
    public String login(Model model) {
        return "/chick/t_login";
    }

    @GetMapping("/chickinfo")
    public String teacherinfo(Model model) {
        return "/chick/teacherinfo";
    }

    @GetMapping("/myinfo")
    public String myinfo(Model model) {
        return "/chick/t_myinfo";
    }

    @GetMapping("/addkinder")
    public String addkinder(Model model) {
        return "/chick/addkinder";
    }


    //선생님 로그인 성공
    @PostMapping("/teacherSuccess")
    public String teacherSuccess(@ModelAttribute TeacherDTO teacherDTO, Model model, HttpSession session) {
        TeacherDTO loginResult = teacherService.login(teacherDTO);
        if (loginResult != null) {
            //로그인 성공
            session.setAttribute("teacherId", loginResult.getTeacherId());
            session.setAttribute("teacherPass", loginResult.getTeacherPass());
            session.setAttribute("teacherName", loginResult.getTeacherName());
            session.setAttribute("teacherPhoneNumber", loginResult.getTeacherPhoneNumber());

            System.out.println("teacherId: " + session.getAttribute("teacherId"));
            System.out.println("teacherPass: " + session.getAttribute("teacherPass"));
            System.out.println("teacherName: " + session.getAttribute("teacherName"));
            System.out.println("teacherPhoneNumber: " + session.getAttribute("teacherPhoneNumber"));

            model.addAttribute("message", "로그인에 성공하셨습니다!");
            model.addAttribute("status", "success");
            return "message"; // 모달을 띄우기 위한 페이지
        } else {
            // 로그인 실패
            model.addAttribute("message", "아이디 혹은 비밀번호를 다시 확인해주시기 바랍니다.");
            model.addAttribute("status", "fail");
            return "message"; // 모달을 띄우기 위한 페이지
        }
    }
}
