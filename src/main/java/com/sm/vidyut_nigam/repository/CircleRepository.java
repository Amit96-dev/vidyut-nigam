package com.sm.vidyut_nigam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Circle;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Integer> {
    List<Circle> findByActive(boolean active);

    List<Circle> findByDiscom_DiscomCodeAndActive(int discomCode, boolean active);

    List<Circle> findByDiscom_DiscomCode(int discomCode);

    int countByDiscom_DiscomCode(int discomCode);

    Optional<Circle> findByCircleCodeAndDiscom_DiscomCode(int circleCode, int discomCode);
}
