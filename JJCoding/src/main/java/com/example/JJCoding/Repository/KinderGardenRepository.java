package com.example.JJCoding.Repository;

import com.example.JJCoding.Entity.KinderGardenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinderGardenRepository extends JpaRepository<KinderGardenEntity,Long> {
}
