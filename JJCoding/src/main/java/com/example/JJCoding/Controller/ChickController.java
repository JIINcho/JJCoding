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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String sign() {
        return "/chick/teachersignin";
    }

    //회원가입페이지2
    @GetMapping("/chick/sign2")
    public String sign2() {
        return "/chick/teacherinfo";
    }

    //회원정보 받아오기1
    @PostMapping("/teacherSave1")
    public String teacherSave1(@ModelAttribute TeacherDTO teacherDTO, HttpSession session) {
        session.setAttribute("teacherDTO", teacherDTO);
        return "redirect:/chick/sign2";
    }

    //선생님 회원가입 성공
    @PostMapping("/teacherSave")
    public String teacherSave(@ModelAttribute TeacherDTO teacherDTO, HttpSession session) {
        // 세션에서 teacherDTO 가져오기
        TeacherDTO sessionTeacherDTO = (TeacherDTO) session.getAttribute("teacherDTO");

        if (sessionTeacherDTO != null) {
            // 세션에 저장된 값 유지, 두 번째 페이지에서 받은 값 병합
            if (teacherDTO.getTeacherId() != null) {
                sessionTeacherDTO.setTeacherId(teacherDTO.getTeacherId());
            }
            if (teacherDTO.getTeacherPass() != null) {
                sessionTeacherDTO.setTeacherPass(teacherDTO.getTeacherPass());
            }
            if (teacherDTO.getTeacherName() != null) {
                sessionTeacherDTO.setTeacherName(teacherDTO.getTeacherName());
            }
            if (teacherDTO.getTeacherGender() != null) {
                sessionTeacherDTO.setTeacherGender(teacherDTO.getTeacherGender());
            }
            if (teacherDTO.getTeacherPhoneNumber() != null) {
                sessionTeacherDTO.setTeacherPhoneNumber(teacherDTO.getTeacherPhoneNumber());
            }

            // 병합된 정보를 최종적으로 저장
            teacherService.save(sessionTeacherDTO);

            // 세션에서 객체 제거 (필요에 따라)
            session.removeAttribute("teacherDTO");

            System.out.println("최종 저장 teacherDTO: " + sessionTeacherDTO);
        } else {
            // 세션에 teacherDTO가 없으면 첫 번째 페이지로 리다이렉트
            return "redirect:/chick/sign";
        }

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

    @GetMapping("/check-teacherID")
    public boolean checkTeacherID(@RequestParam String teacherID) {
        return teacherService.TeacherIdCheck(teacherID);
    }
}
