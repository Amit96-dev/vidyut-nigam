package com.sm.vidyut_nigam.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;
import com.sm.vidyut_nigam.entity.consumer.Consumer;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        // Explicit mapping for Consumer to ConsumerResponseDTO
        modelMapper.addMappings(new PropertyMap<Consumer, ConsumerResponseDTO>() {
            @Override
            protected void configure() {
                map().setSection(source.getSection().getSectionCode());
                map().setTransformer(source.getTransformer().getTransformerCode());
            }
        });

        return modelMapper;
    }
}
