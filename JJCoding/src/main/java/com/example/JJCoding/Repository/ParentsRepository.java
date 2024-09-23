package com.example.JJCoding.Repository;

import com.example.JJCoding.Entity.ParentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentsRepository extends JpaRepository<ParentsEntity, Long> {
    //부모님의 아이디를 찾음
    Optional<ParentsEntity> findByParentsId(String parentsId);
}
