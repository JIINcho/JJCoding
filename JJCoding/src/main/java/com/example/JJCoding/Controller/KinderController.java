package com.example.JJCoding.Controller;

import com.example.JJCoding.DTO.KinderGardenDTO;
import com.example.JJCoding.Entity.KinderGardenEntity;
import com.example.JJCoding.Repository.KinderGardenRepository;
import com.example.JJCoding.Service.KinderGardenService;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class KinderController {

    private final KinderGardenService kinderGardenService;
    private final KinderGardenRepository kinderGardenRepository;

    @GetMapping("/addkinder")
    public String addkinder(Model model) {
        return "/chick/addkinder";
    }

    @GetMapping("/kinderdetail")
    public String kinderdetail(Model model) {
        return "/chick/kinderinfo";
    }

    @PostMapping("/addkinder")
    public String kinderGardenSave(@ModelAttribute KinderGardenDTO kinderGardenDTO, HttpSession session, Model model) {
        try {
            kinderGardenService.save(kinderGardenDTO, session);
            model.addAttribute("message", "유치원이 성공적으로 저장되었습니다!");
            return "redirect:/myinfo"; // 성공 페이지로 리다이렉트
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error"; // 오류 페이지로 이동
        }
    }

    //아이 상세정보
    @PostMapping("/kindergarden/detail")
    public String kindergardendetail(@RequestParam("id") Long Id, Model model) {

        KinderGardenEntity kinderGarden = kinderGardenRepository.findById(Id).orElse(null);

        model.addAttribute("kinderGarden", kinderGarden);

        return "/chick/kinderinfo";
    }

}
