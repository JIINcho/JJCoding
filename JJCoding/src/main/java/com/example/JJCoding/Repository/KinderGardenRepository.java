package com.example.JJCoding.Repository;

import com.example.JJCoding.Entity.KinderGardenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KinderGardenRepository extends JpaRepository<KinderGardenEntity,Long> {
    List<KinderGardenEntity> findByTeacherId(Long Id);
    Optional<KinderGardenEntity> findById(Long Id);
}
