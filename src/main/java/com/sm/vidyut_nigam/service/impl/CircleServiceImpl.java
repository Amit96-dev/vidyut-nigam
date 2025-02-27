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
import com.sm.vidyut_nigam.dto.CardStuructureResponse.CircleCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.CircleResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.CircleTreeDTO;
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

    // create circle

    @Override
    public String createCircle(CircleDTO circleDTO) {
        try {
            int code = circleRepository.countByDiscom_DiscomCode(circleDTO.getDiscomCode());
        String circleCode = Integer.toString(circleDTO.getDiscomCode()) +
                Integer.toString(code + 1);
        circleDTO.setCircleCode(Integer.parseInt(circleCode));
        circleRepository.save(mapper.map(circleDTO, Circle.class));
        return "Circle Created Successfully";
        } catch (Exception e) {
            return "Error in Creating Circle/n" + e.getMessage();
        }
    }

    // Get all circles by discom code

    @Override
    public List<CircleResponse> getAllCirclesByDiscomCode(int discomCode) {
        List<Circle> circleList = circleRepository.findByDiscom_DiscomCode(discomCode);
        List<CircleResponse> circleDTOslist = circleList.stream()
                .map(circle -> mapper.map(circle, CircleResponse.class))
                .toList();
        return circleDTOslist;
    }

    @Override
    public CircleResponse getCircleByCode(int circleCode) {
        Circle circle = circleRepository.findById(circleCode)
                .orElseThrow(() -> new RuntimeException("Circle not found with given ID="));
        return mapper.map(circle, CircleResponse.class);
    }

    @Override
    public List<CircleResponse> getCircleByActive(boolean active) {
        List<Circle> byActive = circleRepository.findByCircleActive(active);
        List<CircleResponse> circleDTOList = byActive.stream().map(a -> mapper.map(a,
        CircleResponse.class)).toList();
        return circleDTOList;
    }

    @Override
    public List<CircleResponse> getActiveCircleByDiscomCode(int discomCode, boolean active) {
        List<Circle> byActive = circleRepository.findByDiscom_DiscomCodeAndCircleActive(discomCode, active);
        List<CircleResponse> circleDTOList = byActive.stream().map(a -> mapper.map(a,
        CircleResponse.class)).toList();
        return circleDTOList;
    }

    @Override
    public List<CircleCardDTO> getActiveCircleCardByDiscomCode(int discomCode, boolean active) {
        List<Circle> byActive = circleRepository.findByDiscom_DiscomCodeAndCircleActive(discomCode, active);
        List<CircleCardDTO> circleCardDTOList = byActive.stream().map(a -> mapper.map(a,
                CircleCardDTO.class)).toList();
        return circleCardDTOList;
    }

    @Override
    public List<CircleTreeDTO> getActiveCircleTreeByDiscomCode(int discomCode, boolean active) {
        List<Circle> byActive = circleRepository.findByDiscom_DiscomCodeAndCircleActive(discomCode, active);
        List<CircleTreeDTO> circleTreeDTOList = byActive.stream().map(a -> mapper.map(a,
                CircleTreeDTO.class)).toList();
        return circleTreeDTOList;
    }

    @Override
    public String updateCircle(int circleCode, CircleUpdateDTO circleDTO) {
        try {
            Circle existingCircle = circleRepository.findById(circleCode)
                .orElseThrow(() -> new RuntimeException("Circle not found with given ID."));
        BeanUtils.copyProperties(circleDTO, existingCircle);
        existingCircle.setCircleUpdatedAt(LocalDateTime.now());
        circleRepository.save(existingCircle);
        return "Circle Updated Successfully";
        } catch (Exception e) {
            return "Error while updating Circle" + e.getMessage();
        }
    }

    @Override
    public String deleteCircle(int circleCode) {
        try {
            Circle existingCircle = circleRepository.findById(circleCode)
                    .orElseThrow(() -> new RuntimeException("Circle not found with given ID."));
            existingCircle.setCircleActive(false);
            circleRepository.save(existingCircle);
            return "Circle Deleted Successfully";
        } catch (Exception e) {
            return "Something Went Wrong";
        }
    }

}
