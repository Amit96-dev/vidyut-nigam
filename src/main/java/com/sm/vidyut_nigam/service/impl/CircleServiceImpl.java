package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;
import com.sm.vidyut_nigam.entity.Circle;
import com.sm.vidyut_nigam.repository.CircleRepository;
import com.sm.vidyut_nigam.service.CircleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CircleServiceImpl implements CircleService {

    private final CircleRepository circleRepository;

    private final ModelMapper mapper;

    Logger logger = LoggerFactory.getLogger(CircleServiceImpl.class);

    @Override
    public CircleDTO createCircle(CircleDTO circleDTO) {
        // logger.info("*********************** {}", circleDTO);
        int code = circleRepository.countByDiscom_DiscomCode(circleDTO.getDiscomCode());
        logger.info("*******code:{}", code);
        circleDTO.setCircleCode(code + 1);
        logger.info("*******circleDTO:{}", circleDTO);
        Circle circle = circleRepository.save(mapper.map(circleDTO, Circle.class));

        return mapper.map(circle, CircleDTO.class);
    }

    @Override
    public List<CircleDTO> getAllCircles(int discomCode) {
        List<Circle> circleList = circleRepository.findByDiscom_DiscomCode(discomCode);
        List<CircleDTO> circleDTOslist = circleList.stream().map(circle -> mapper.map(circle, CircleDTO.class))
                .toList();
        return circleDTOslist;
    }

    @Override
    public CircleDTO getCircleByCode(int circleCode, int discomCode) {
        Circle circle = circleRepository.findByCircleCodeAndDiscom_DiscomCode(circleCode, discomCode)
                .orElseThrow(() -> new RuntimeException("Circle not found with given ID."));
        return mapper.map(circle, CircleDTO.class);
    }

    @Override
    public List<CircleDTO> getCircleByActive(boolean active) {
        List<Circle> byActive = circleRepository.findByActive(active);
        List<CircleDTO> circleDTOList = byActive.stream().map(a -> mapper.map(a, CircleDTO.class)).toList();
        return circleDTOList;
    }

    @Override
    public List<CircleDTO> getActiveCircleByDiscomCode(int discomCode, boolean active) {
        List<Circle> byActive = circleRepository.findByDiscom_DiscomCodeAndActive(discomCode, active);
        List<CircleDTO> circleDTOList = byActive.stream().map(a -> mapper.map(a, CircleDTO.class)).toList();
        return circleDTOList;
    }

    @Override
    public CircleDTO updateCircle(int circleCode, int discomeCode, CircleUpdateDTO circleDTO) {
        Circle existingCircle = circleRepository.findByCircleCodeAndDiscom_DiscomCode(circleCode, discomeCode)
                .orElseThrow(() -> new RuntimeException("Circle not found with given ID."));

        logger.info("existing Circle:{}", existingCircle);
        BeanUtils.copyProperties(circleDTO, existingCircle);

        existingCircle.setUpdatedAt(LocalDateTime.now());
        Circle circle1 = circleRepository.save(existingCircle);

        return mapper.map(circle1, CircleDTO.class);
    }

    @Override
    public String deleteCircle(int circleCode, int discomCode) {
        try {
            Circle existingCircle = circleRepository.findByCircleCodeAndDiscom_DiscomCode(circleCode, discomCode)
                    .orElseThrow(() -> new RuntimeException("Circle not found with given ID."));
            existingCircle.setActive(false);
            circleRepository.save(existingCircle);
            return "Circle Deleted Successfully";
        } catch (Exception e) {
            return "Something Went Wrong";
        }
    }

}
