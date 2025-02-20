package com.sm.vidyut_nigam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.SubDivision;

@Repository
public interface SubDivisionRepository extends JpaRepository<SubDivision, Integer> {
    int countByDivision_DivisionCode(int divisionCode);

    List<SubDivision> findByActive(boolean active);

    List<SubDivision> findByDivision_DivisionCodeAndActive(int divisionCode, boolean active);

    Optional<SubDivision> findBySubDivisionCodeAndDivision_DivisionCode(int subDivisionCode, int divisionCode);
}
