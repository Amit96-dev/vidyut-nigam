package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.dto.DivisionUpdateDTO;
import com.sm.vidyut_nigam.entity.Division;
import com.sm.vidyut_nigam.repository.DivisionRepository;
import com.sm.vidyut_nigam.service.DivisionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DivisionServiceImpl implements DivisionService{

    private final DivisionRepository divisionRepository;
    private ModelMapper mapper;

    @Override
    public DivisionDTO createDivision(DivisionDTO divisionDTO) {
        Division division = divisionRepository.save(mapper.map(divisionDTO, Division.class));
        return mapper.map(division, DivisionDTO.class);
    }

    @Override
    public List<DivisionDTO> getAllDivisions() {
        List<Division> Divisions = divisionRepository.findAll();
        return Divisions.stream().map(division -> mapper.map(division, DivisionDTO.class)).toList();
    }

    @Override
    public DivisionDTO getDivisionByDivisionCode(int divisionCode) {
        Division division = divisionRepository.findById(divisionCode).orElseThrow(()-> new RuntimeException("Division not found with given division code"));
        return mapper.map(division, DivisionDTO.class);
    }

    @Override
    public DivisionDTO updateDivision(DivisionUpdateDTO divisionUpdateDTO, int divisionCode) {
        Division division = divisionRepository.findById(divisionCode).orElseThrow(()-> new RuntimeException("Division not found by given division code"));
        BeanUtils.copyProperties(divisionUpdateDTO, division);
        division.setUpdatedAt(LocalDateTime.now());
        return mapper.map(divisionRepository.save(division), DivisionDTO.class);
    }

    @Override
    public List<DivisionDTO> findDivisionByActive(boolean active) {
        List<Division> divisions = divisionRepository.findByActive(active);
        return divisions.stream().map(division -> mapper.map(division, DivisionDTO.class)).toList();
    }

    @Override
    public String deleteDivision(int divisionCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDivision'");
    }
    
}
