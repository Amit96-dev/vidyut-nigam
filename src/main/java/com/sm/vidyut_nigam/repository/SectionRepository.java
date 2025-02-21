package com.sm.vidyut_nigam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.vidyut_nigam.entity.Section;
import java.util.List;
import java.util.Optional;


@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findBySectionActive(boolean active);

    int countBySectionParentCode_subDivisionCode(int subDivisionCode);

    List<Section> findBySectionParentCode_subDivisionCodeAndSectionActive(int subDivisionCode, boolean active);

    List<Section> findBysectionParentCode_subDivisionCode(int subDivisionCode);

    Optional<Section> findBySectionCodeAndSectionParentCode_subDivisionCode(int sectionCode, int subDivisionCode);
}
