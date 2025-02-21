package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
import com.sm.vidyut_nigam.entity.Section;
import com.sm.vidyut_nigam.repository.SectionRepository;
import com.sm.vidyut_nigam.service.SectionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    private final ModelMapper mapper;

    @Override
    public SectionDTO createSection(SectionDTO sectionDTO) {
        int sectionParentCode = sectionRepository
                .countBySectionParentCode_subDivisionCode(sectionDTO.getSectionParentCode());
        String sectionCode = Integer.toString(sectionDTO.getSectionParentCode())
                + Integer.toString(sectionParentCode + 1);
        sectionDTO.setSectionCode(Integer.parseInt(sectionCode));
        Section section = sectionRepository.save(mapper.map(sectionDTO, Section.class));
        return mapper.map(section, SectionDTO.class);
    }

    @Override
    public SectionDTO getSectionBySectionCode(int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code"));
        return mapper.map(section, SectionDTO.class);
    }

    @Override
    public List<SectionDTO> getAllSection() {
        List<Section> sections = sectionRepository.findAll();
        return sections.stream().map(section -> mapper.map(section, SectionDTO.class)).toList();
    }

    @Override
    public SectionDTO updateSection(SectionUpdateDTO sectionUpdateDTO, int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code"));
        BeanUtils.copyProperties(sectionUpdateDTO, section);
        section.setSectionUpdatedAt(LocalDateTime.now());
        Section section1 = sectionRepository.save(section);
        return mapper.map(section1, SectionDTO.class);
    }

    @Override
    public String deactivateSection(int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code"));
        section.setSectionActive(false);
        sectionRepository.save(section);
        return "Section deactivated successfully";
    }

    @Override
    public List<SectionDTO> getSectionByActive(boolean active) {
        List<Section> sections = sectionRepository.findBySectionActive(active);
        return sections.stream().map(section -> mapper.map(section, SectionDTO.class)).toList();
    }

    @Override
    public List<SectionDTO> getActiveSectionBySubDivisionCode(int subDivisionCode, boolean active) {
        List<Section> sections = sectionRepository
                .findBySectionParentCode_subDivisionCodeAndSectionActive(subDivisionCode, active);
        return sections.stream().map(section -> mapper.map(section, SectionDTO.class)).toList();
    }

}
