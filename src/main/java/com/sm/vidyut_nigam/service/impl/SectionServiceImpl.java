package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.config.SectionMapper;
import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
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
    public SectionDTO createSection(SectionDTO sectionDTO) {
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

            // Convert Entity back to DTO
            SectionDTO responseDTO = sectionMapper.toDTO(section);

            return responseDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating section", e);
        }
    }

    @Override
    public SectionDTO getSectionBySectionCode(int sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new RuntimeException("Section not found with given section code = "));
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
                .orElseThrow(() -> new RuntimeException("Section not found with given section code = "));
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
                .findBySubDivision_subDivisionCodeAndSectionActive(subDivisionCode, active);
        return sections.stream().map(section -> mapper.map(section, SectionDTO.class)).toList();
    }

}
