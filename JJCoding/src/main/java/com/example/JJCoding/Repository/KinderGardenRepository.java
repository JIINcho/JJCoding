package com.example.JJCoding.Repository;

import com.example.JJCoding.Entity.KinderGardenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KinderGardenRepository extends JpaRepository<KinderGardenEntity,Long> {
    List<KinderGardenEntity> findByTeacherId(Long Id);
}
