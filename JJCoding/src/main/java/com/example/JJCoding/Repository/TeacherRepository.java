package com.example.JJCoding.Repository;

import com.example.JJCoding.Entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    //선생님의 아이디를 찾음
    Optional<TeacherEntity> findByTeacherId(String teacherId);

    Optional<TeacherEntity> findById(Long id);
}
