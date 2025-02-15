package com.sm.vidyut_nigam.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.entity.Circle;
import com.sm.vidyut_nigam.repository.CircleRepository;
import com.sm.vidyut_nigam.service.CircleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CircleServiceImpl implements CircleService {

    private final CircleRepository circleRepository;

    private final ModelMapper mapper;
    

    @Override
    public CircleDTO createCircle(CircleDTO circleDTO) {
        Circle circle = circleRepository.save(mapper.map(circleDTO, Circle.class));
        return mapper.map(circle, CircleDTO.class);
    }

    @Override
    public List<CircleDTO> getAllCircles() {
        List<Circle> circleList = circleRepository.findAll();
        List<CircleDTO> circleDTOslist = circleList.stream().map(circle -> mapper.map(circleList, CircleDTO.class))
                .toList();
        return circleDTOslist;
    }
    
}
