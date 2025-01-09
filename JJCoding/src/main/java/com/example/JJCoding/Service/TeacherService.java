package com.example.JJCoding.Service;

import com.example.JJCoding.DTO.EditTeacherDTO;
import com.example.JJCoding.DTO.TeacherDTO;
import com.example.JJCoding.Entity.TeacherEntity;
import com.example.JJCoding.Repository.TeacherRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Transactional
    public void save(TeacherDTO teacherDTO) {
        TeacherEntity teacherEntity = TeacherEntity.toTeacherEntity(teacherDTO);
        teacherRepository.save(teacherEntity);
    }

    public TeacherDTO login(TeacherDTO teacherDTO) {
        // null 체크 추가
        if (teacherDTO == null || teacherDTO.getTeacherId() == null) {
            throw new IllegalArgumentException("TeacherDTO or TeacherId is null");
        }

        Optional<TeacherEntity> teacherId = teacherRepository.findByTeacherId(teacherDTO.getTeacherId());
        if(teacherId.isPresent()){
            TeacherEntity teacherEntity = teacherId.get();
            if(teacherEntity.getTeacherPass().equals(teacherDTO.getTeacherPass())) {
                TeacherDTO dto = TeacherDTO.toTeacherDTO(teacherEntity);
                return dto;
            }
            else {
                return null;
            }
        }
        return null;
    }

    public boolean isTeacherIdExists(String teacherId) {
        return teacherRepository.findByTeacherId(teacherId).isPresent();
    }
}
