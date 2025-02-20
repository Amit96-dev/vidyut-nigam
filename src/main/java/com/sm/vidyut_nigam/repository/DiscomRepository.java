package com.sm.vidyut_nigam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sm.vidyut_nigam.entity.Discom;

@Repository
public interface DiscomRepository extends JpaRepository<Discom, Integer> {
    List<Discom> findByDiscomActive(boolean active);
}
