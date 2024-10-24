package com.example.JJCoding.Service;

import com.example.JJCoding.DTO.KinderGardenDTO;
import com.example.JJCoding.Entity.KinderGardenEntity;
import com.example.JJCoding.Entity.TeacherEntity;
import com.example.JJCoding.Repository.KinderGardenRepository;
import com.example.JJCoding.Repository.TeacherRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KinderGardenService {

    @Autowired
    private KinderGardenRepository kinderGardenRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void save(KinderGardenDTO kinderGardenDTO, HttpSession session) {
        // 세션에서 teacherId 가져오기
        String teacherId = (String) session.getAttribute("teacherId");

        if (teacherId == null) {
            throw new IllegalArgumentException("No teacherId found in session");
        }

        // teacherId를 사용하여 TeacherEntity 조회
        TeacherEntity teacher = teacherRepository.findByTeacherId(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found"));

        // DTO를 엔티티로 변환
        KinderGardenEntity kinderGardenEntity = KinderGardenEntity.toKinderGardenEntity(kinderGardenDTO);
        kinderGardenEntity.setTeacher(teacher); // teacher 설정

        // 유치원 엔티티 저장
        kinderGardenRepository.save(kinderGardenEntity);
    }

    public List<KinderGardenEntity> getKinderGardenByTeacherId(Long Id) {
        return kinderGardenRepository.findByTeacherId(Id);
    }
}
