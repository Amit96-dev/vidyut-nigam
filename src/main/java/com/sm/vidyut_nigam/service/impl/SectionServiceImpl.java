package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.config.SectionMapper;
import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.SectionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.SectionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.SectionTreeDTO;
import com.sm.vidyut_nigam.entity.Section;
import com.sm.vidyut_nigam.entity.SubDivision;
import com.sm.vidyut_nigam.repository.SectionRepository;
import com.sm.vidyut_nigam.repository.SubDivisionRepository;
import com.sm.vidyut_nigam.service.SectionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    private final SubDivisionRepository subDivisionRepository;;

    private final SectionMapper sectionMapper;

    private final ModelMapper mapper;

    @Override
    public String createSection(SectionDTO sectionDTO) {
        SubDivision subDivision = subDivisionRepository.findById(sectionDTO.getSubDivisionCode())
                .orElseThrow(() -> new RuntimeException("SubDivision not found"));

        try {
            int sectionParentCode = sectionRepository
                    .countBySubDivision_subDivisionCode(sectionDTO.getSubDivisionCode());

            String sectionCode = Integer.toString(sectionDTO.getSubDivisionCode()) + (sectionParentCode + 1);
            sectionDTO.setSectionCode(Integer.parseInt(sectionCode));

            // Convert DTO to Entity
            Section section = sectionMapper.toEntity(sectionDTO);
            section.setSubDivision(subDivision);

            // Save Section
            section = sectionRepository.save(section);

            return "Section Created Successfully";
        } catch (Exception e) {
            return "Error creating section"+ e.getMessage();
        }
    }

    @Override
    public SectionResponse getSectionBySectionCode(int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code = "));
        return mapper.map(section, SectionResponse.class);
    }

    @Override
    public List<SectionResponse> getAllSection() {
        List<Section> sections = sectionRepository.findAll();
        return sections.stream().map(section -> mapper.map(section, SectionResponse.class)).toList();
    }

    @Override
    public String updateSection(SectionUpdateDTO sectionUpdateDTO, int sectionCode) {
        try {
            Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code"));
        BeanUtils.copyProperties(sectionUpdateDTO, section);
        section.setSectionUpdatedAt(LocalDateTime.now());
        sectionRepository.save(section);
        return "Section Updated Successfully";
        } catch (Exception e) {
            return "Error updating section"+ e.getMessage();
        }
    }

    @Override
    public String deactivateSection(int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code = "));
        section.setSectionActive(false);
        sectionRepository.save(section);
        return "Section deactivated successfully";
    }

    @Override
    public List<SectionResponse> getSectionByActive(boolean active) {
        List<Section> sections = sectionRepository.findBySectionActive(active);
        return sections.stream().map(section -> mapper.map(section, SectionResponse.class)).toList();
    }

    @Override
    public List<SectionResponse> getActiveSectionBySubDivisionCode(int subDivisionCode, boolean active) {
        List<Section> sections = sectionRepository
                .findBySubDivision_subDivisionCodeAndSectionActive(subDivisionCode, active);
        return sections.stream().map(section -> mapper.map(section, SectionResponse.class)).toList();
    }

    @Override
    public List<SectionCardDTO> getActiveSectionCardBySubDivisionCode(int subDivisionCode, boolean active) {
        List<Section> sections = sectionRepository
                .findBySubDivision_subDivisionCodeAndSectionActive(subDivisionCode, active);
        return sections.stream().map(section -> mapper.map(section, SectionCardDTO.class)).toList();
    }

    @Override
    public List<SectionTreeDTO> getActiveSectionTreeBySubDivisionCode(int subDivisionCode, boolean active) {
        List<Section> sections = sectionRepository
                .findBySubDivision_subDivisionCodeAndSectionActive(subDivisionCode, active);
        return sections.stream().map(section -> mapper.map(section, SectionTreeDTO.class)).toList();
    }

}
