package com.sm.vidyut_nigam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Circle;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Integer> {
    
}
