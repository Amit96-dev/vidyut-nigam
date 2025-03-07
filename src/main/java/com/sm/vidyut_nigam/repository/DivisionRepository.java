package com.sm.vidyut_nigam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
    List<Division> findByDivisionActive(boolean active);

    int countByCircle_CircleCode(int circleCode);

    List<Division> findByCircle_CircleCodeAndDivisionActive(int circleCode, boolean active);
}
