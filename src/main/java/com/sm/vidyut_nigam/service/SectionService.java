package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;

public interface SectionService {
    SectionDTO createSection(SectionDTO sectionDTO);
    SectionDTO getSectionBySectionCode(int sectionCode);
    List<SectionDTO> getAllSection();
    SectionDTO updateSection(SectionUpdateDTO sectionUpdateDTO, int sectionCode);
    String deactivateSection(int sectionCode);
    List<SectionDTO> getSectionByActive(boolean active);
    List<SectionDTO> getActiveSectionBySubDivisionCode(int subDivisionCode, boolean active);
}
