package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.SectionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.SectionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.SectionTreeDTO;

public interface SectionService {
    SectionDTO createSection(SectionDTO sectionDTO);

    SectionResponse getSectionBySectionCode(int sectionCode);

    List<SectionDTO> getAllSection();

    SectionDTO updateSection(SectionUpdateDTO sectionUpdateDTO, int sectionCode);

    String deactivateSection(int sectionCode);

    List<SectionDTO> getSectionByActive(boolean active);

    List<SectionDTO> getActiveSectionBySubDivisionCode(int subDivisionCode, boolean active);

    List<SectionCardDTO> getActiveSectionCardBySubDivisionCode(int subDivisionCode, boolean active);

    List<SectionTreeDTO> getActiveSectionTreeBySubDivisionCode(int subDivisionCode, boolean active);

}
