package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.SubDivisionDTO;
import com.sm.vidyut_nigam.dto.SubDivisionUpdateDTO;
import com.sm.vidyut_nigam.entity.Division;
import com.sm.vidyut_nigam.entity.SubDivision;
import com.sm.vidyut_nigam.repository.DivisionRepository;
import com.sm.vidyut_nigam.repository.SubDivisionRepository;
import com.sm.vidyut_nigam.service.SubDivisionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubDivisionServiceImpl implements SubDivisionService {

    private final SubDivisionRepository subDivisionRepository;

    private final DivisionRepository divisionRepository;

    private final ModelMapper mapper;

    // Create SubDivision
    @Override
    public SubDivisionDTO createSubDivision(SubDivisionDTO subDivisionDTO) {

        Division division = divisionRepository.findById(subDivisionDTO.getDivisionCode())
                .orElseThrow(() -> new RuntimeException("Division not found with code: "
                        + subDivisionDTO.getDivisionCode()));

        int count = subDivisionRepository.countByDivision_DivisionCode(division.getDivisionCode());

        String subDivisionCode = division.getDivisionCode() + "" + (count + 1);
        subDivisionDTO.setSubDivisionCode(Integer.parseInt(subDivisionCode));

        SubDivision subDivision = mapper.map(subDivisionDTO, SubDivision.class);

        subDivision.setDivision(division);

        subDivision = subDivisionRepository.save(subDivision);

        SubDivisionDTO savedDTO = mapper.map(subDivision, SubDivisionDTO.class);

        savedDTO.setDivisionCode(division.getDivisionCode());

        return savedDTO;
    }

    // Get SubDivision By SubDivisionCode
    @Override
    public SubDivisionDTO getSubDivisionBySubDivisionCode(int subDivisionCode) {
        SubDivision subDivision = subDivisionRepository.findById(subDivisionCode)
                .orElseThrow(() -> new RuntimeException("Sub-division not found with given sub-division code = "));
        return mapper.map(subDivision, SubDivisionDTO.class);
    }

    // Get all SubDivisions
    @Override
    public List<SubDivisionDTO> getAllSubDivisions() {
        List<SubDivision> subDivisionList = subDivisionRepository.findAll();
        return subDivisionList.stream().map(subDivision -> mapper.map(subDivision, SubDivisionDTO.class)).toList();
    }

    // Deactivate SubDivision
    @Override
    public String deactivateSubDivision(int subDivisionCode) {
        SubDivision subDivision = subDivisionRepository.findById(subDivisionCode)
                .orElseThrow(() -> new RuntimeException("Sub-division not found with given sub-division code"));
        subDivision.setSubDivisionActive(false);
        subDivisionRepository.save(subDivision);
        return "SubDivision deactivated successfully";
    }

    // Update SubDivision
    @Override
    public SubDivisionDTO updateSubDivision(SubDivisionUpdateDTO subDivisionUpdateDTO, int subDivisionCode) {
        SubDivision subDivision = subDivisionRepository.findById(subDivisionCode)
                .orElseThrow(() -> new RuntimeException("Sub-division not found with given sub-division code"));
        BeanUtils.copyProperties(subDivisionUpdateDTO, subDivision);
        subDivision.setSubDivisionUpdatedAt(LocalDateTime.now());
        subDivisionRepository.save(subDivision);
        return mapper.map(subDivision, SubDivisionDTO.class);
    }

    // Get SubDivision By active
    @Override
    public List<SubDivisionDTO> getSubDivisionByActive(boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository.findBySubDivisionActive(active);
        return subDivisionList.stream().map(subDivision -> mapper.map(subDivision, SubDivisionDTO.class)).toList();
    }

    // Get Active SubDivision By DivisionCode
    @Override
    public List<SubDivisionDTO> getActiveSubDivisionByDivisionCode(int divisionCode, boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository
                .findByDivision_DivisionCodeAndSubDivisionActive(divisionCode, active);
        System.out.println(subDivisionList);
        List<SubDivisionDTO> subDivisionDTOList = subDivisionList.stream()
                .map(subdivision -> mapper.map(subdivision, SubDivisionDTO.class)) // Corrected this line
                .toList();
        return subDivisionDTOList;
    }

}
