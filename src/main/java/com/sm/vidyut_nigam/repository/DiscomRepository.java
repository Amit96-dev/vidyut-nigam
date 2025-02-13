package com.sm.vidyut_nigam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Discom;

@Repository
public interface DiscomRepository extends JpaRepository<Discom, Integer>{
    Discom findByDiscomCode(String code);
    
}
