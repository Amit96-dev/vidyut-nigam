package com.sm.vidyut_nigam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Section;
import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findBySectionActive(boolean active);

    int countBySubDivision_subDivisionCode(int subDivisionCode);

    List<Section> findBySubDivision_subDivisionCodeAndSectionActive(int subDivisionCode, boolean active);

    List<Section> findBySubDivision_subDivisionCode(int subDivisionCode);

    Optional<Section> findBySectionCodeAndSubDivision_subDivisionCode(int sectionCode, int subDivisionCode);
}
