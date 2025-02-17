package com.sm.vidyut_nigam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Circle;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Integer> {
    List<Circle> findByActive(boolean active);

    int countByDiscom_DiscomCode(int discomCode);
}
