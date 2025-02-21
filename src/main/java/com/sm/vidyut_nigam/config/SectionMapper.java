package com.sm.vidyut_nigam.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.entity.Section;

@Component
public class SectionMapper {

    private final ModelMapper modelMapper;

    public SectionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        configureMappings();
    }

    private void configureMappings() {
        modelMapper.addMappings(new PropertyMap<Section, SectionDTO>() {
            @Override
            protected void configure() {
                map().setSubDivisionCode(source.getSubDivision().getSubDivisionCode());
            }
        });
    }

    public SectionDTO toDTO(Section section) {
        return modelMapper.map(section, SectionDTO.class);
    }

    public Section toEntity(SectionDTO sectionDTO) {
        return modelMapper.map(sectionDTO, Section.class);
    }
}
