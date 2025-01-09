package com.example.JJCoding.Controller;


import com.example.JJCoding.Entity.ParentsEntity;
import com.example.JJCoding.Repository.ParentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.JJCoding.DTO.ParentsDTO;
import com.example.JJCoding.Service.ParentsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChickenController {

    private final ParentsService parentsService;
    private final ParentsRepository parentsRepository;

    @GetMapping("/chicken")
    public String Chicken(Model model) {
        return "/chicken/chicken";
    }

    @GetMapping("/chicken/signin")
    public String parentsSave1(Model model) {
        return "/chicken/p_signin";
    }

    //부모님 회원가입 1
    @PostMapping("/parentsSave1")
    public String parentsSave1(@ModelAttribute ParentsDTO parentsDTO, HttpSession session) {
        session.setAttribute("parentsDTO", parentsDTO);
        return "redirect:/parentsSave2";
    }


    @GetMapping("/parentsSave2")
    public String parentsSave2(Model model) {
        return "/chicken/p_info";
    }

    //부모님 회원가입 2
    @PostMapping("/parentsSave2")
    public String parentsSave2(@ModelAttribute ParentsDTO parentsDTO, HttpSession session) {
        ParentsDTO sessionParentsDTO = (ParentsDTO) session.getAttribute("parentsDTO");

        if(sessionParentsDTO != null){
            if (parentsDTO.getParentsId() != null) {
                sessionParentsDTO.setParentsId(parentsDTO.getParentsId());
            }
            if (parentsDTO.getParentsPass() != null) {
                sessionParentsDTO.setParentsPass(parentsDTO.getParentsPass());
            }
            if (parentsDTO.getParentsName() != null) {
                sessionParentsDTO.setParentsName(parentsDTO.getParentsName());
            }
            if (parentsDTO.getParentsGender() != null) {
                sessionParentsDTO.setParentsGender(parentsDTO.getParentsGender());
            }
            if (parentsDTO.getParentsPhoneNumber() != null) {
                sessionParentsDTO.setParentsPhoneNumber(parentsDTO.getParentsPhoneNumber());
            }
            parentsService.save(sessionParentsDTO);

            session.removeAttribute("parentsDTO");

            System.out.println("최종 저장 parentsDTO" + sessionParentsDTO);
        }
        else {
            return "redirect:/parentsSave1";
        }
        return "redirect:/chicken/login";
    }

    @PostMapping("/api/check-parents-id")
    public ResponseEntity<Boolean> checkParentsId(@RequestBody Map<String, String> request) {
        String parentsId = request.get("parentsId");

        // 입력값 검증
        if (parentsId == null || parentsId.isEmpty()) {
            return ResponseEntity.badRequest().body(false);
        }

        // 아이디 중복 여부 확인
        boolean exists = parentsService.isParentsIdExists(parentsId);
        return ResponseEntity.ok(exists);
    }


    @GetMapping("/chicken/login")
    public String parentsLogin(Model model) {
        return "/chicken/p_login";
    }

    //부모님 로그인 성공
    @PostMapping("/parentsSuccess")
    public String parentsSuccess(@ModelAttribute ParentsDTO parentsDTO, HttpSession session, Model model) {
        System.out.println("parentsDTO = " + parentsDTO + ", session = " + session + ", model = " + model);

        ParentsDTO loginResult = parentsService.login(parentsDTO);

        if(loginResult != null){
            //로그인 성공
            session.setAttribute("Id", loginResult.getId());
            session.setAttribute("parentsId", loginResult.getParentsId());
            session.setAttribute("parentsPass", loginResult.getParentsPass());
            session.setAttribute("parentsName", loginResult.getParentsName());
            session.setAttribute("parentsGender", loginResult.getParentsGender());
            session.setAttribute("parentsPhoneNumber", loginResult.getParentsPhoneNumber());

            return "redirect:/parents/myinfo";
        }
        else {
            // 로그인 실패
            model.addAttribute("parentsmessage", "아이디 혹은 비밀번호를 다시 확인해주세요");
            model.addAttribute("status", "fail");
            return "parentsmessage"; // 모달을 띄우기 위한 페이지
        }

    }

    //부모님 정보
    @GetMapping("/parents/myinfo")
    public String parentsMyinfo(Model model, HttpSession session) {
        Long parentsId = (Long) session.getAttribute("Id");
        ParentsEntity parents = parentsRepository.findById(parentsId).get();
        model.addAttribute("parents", parents);
        return "/chicken/p_myinfo";
    }


}
