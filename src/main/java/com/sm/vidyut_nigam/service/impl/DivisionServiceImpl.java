package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.dto.DivisionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.DivisionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.DivisionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.DivisionTreeDTO;
import com.sm.vidyut_nigam.entity.Division;
import com.sm.vidyut_nigam.repository.DivisionRepository;
import com.sm.vidyut_nigam.service.DivisionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;
    private final ModelMapper mapper;

    Logger logger = LoggerFactory.getLogger(DivisionServiceImpl.class);

    @Override
    public String createDivision(DivisionDTO divisionDTO) {
        try {
            int code = divisionRepository.countByCircle_CircleCode(divisionDTO.getCircleCode());
        String divisionCode = Integer.toString(divisionDTO.getCircleCode()) + Integer.toString(code + 1);
        divisionDTO.setDivisionCode(Integer.parseInt(divisionCode));
        divisionRepository.save(mapper.map(divisionDTO, Division.class));
        return "Division Created Successfully";
        } catch (Exception e) {
            return "Error in Creating Division\n"+ e.getMessage();
        }
    }

    // @Override
    // public List<DivisionDTO> getAllDivisions() {
    // List<Division> Divisions = divisionRepository.findAll();
    // return Divisions.stream().map(division -> mapper.map(division,
    // DivisionDTO.class)).toList();
    // }

    @Override
    public DivisionResponse getDivisionByDivisionCode(int divisionCode) {
        Division division = divisionRepository.findById(divisionCode)
                .orElseThrow(() -> new RuntimeException("Division not found with given division code"));
        return mapper.map(division, DivisionResponse.class);
    }

    @Override
    public String updateDivision(DivisionUpdateDTO divisionUpdateDTO, int divisionCode) {
        try {
            Division division = divisionRepository.findById(divisionCode)
                .orElseThrow(() -> new RuntimeException("Division not found by given division code"));
        BeanUtils.copyProperties(divisionUpdateDTO, division);
        division.setDivisionUpdatedAt(LocalDateTime.now());
        return "Division Updated Successfully";
        } catch (Exception e) {
            return "Error in Updating Division\n"+ e.getMessage();
        }
    }

    @Override
    public List<DivisionResponse> findDivisionByActive(boolean active) {
        List<Division> divisions = divisionRepository.findByDivisionActive(active);
        return divisions.stream().map(division -> mapper.map(division,
        DivisionResponse.class)).toList();
    }

    @Override
    public String deleteDivision(int divisionCode) {
        Division division = divisionRepository.findById(divisionCode)
                .orElseThrow(() -> new RuntimeException("Division not found with given Division code = "));
        division.setDivisionActive(false);
        divisionRepository.save(division);
        return "Division de-activated successfully";
    }

    @Override
    public List<DivisionResponse> findActiveDivisionByCircleCode(int circleCode, boolean active) {
        List<Division> byActive = divisionRepository.findByCircle_CircleCodeAndDivisionActive(circleCode, active);
        List<DivisionResponse> divisionDTOList = byActive.stream().map(a -> mapper.map(a,
        DivisionResponse.class)).toList();
        return divisionDTOList;
    }

    @Override
    public List<DivisionCardDTO> findActiveDivisionCardByCircleCode(int circleCode, boolean active) {
        List<Division> byActive = divisionRepository.findByCircle_CircleCodeAndDivisionActive(circleCode, active);
        List<DivisionCardDTO> divisionCardDTOList = byActive.stream().map(a -> mapper.map(a,
                DivisionCardDTO.class)).toList();
        return divisionCardDTOList;
    }

    @Override
    public List<DivisionTreeDTO> findActiveDivisionTreeByCircleCode(int circleCode, boolean active) {
        List<Division> byActive = divisionRepository.findByCircle_CircleCodeAndDivisionActive(circleCode, active);
        List<DivisionTreeDTO> divisionTreeDTOList = byActive.stream().map(a -> mapper.map(a,
                DivisionTreeDTO.class)).toList();
        return divisionTreeDTOList;
    }

}
