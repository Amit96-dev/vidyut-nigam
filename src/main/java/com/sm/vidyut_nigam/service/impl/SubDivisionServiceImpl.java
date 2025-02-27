package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.SubDivisionDTO;
import com.sm.vidyut_nigam.dto.SubDivisionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.SubDivisionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.SubDivisionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.SubDivisionTreeDTO;
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
    public String createSubDivision(SubDivisionDTO subDivisionDTO) {
        try{
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
        return "Sub Division Created Successfully";

        }catch(Exception e) {
            return "Error while creating Sub Division\n"+ e.getMessage();
        }
    }

    // Get SubDivision By SubDivisionCode
    @Override
    public SubDivisionResponse getSubDivisionBySubDivisionCode(int subDivisionCode) {
        SubDivision subDivision = subDivisionRepository.findById(subDivisionCode)
                .orElseThrow(() -> new RuntimeException("Sub-division not found with given sub-division code = "));
        return mapper.map(subDivision, SubDivisionResponse.class);
    }

    // Get all SubDivisions
    @Override
    public List<SubDivisionResponse> getAllSubDivisions() {
        List<SubDivision> subDivisionList = subDivisionRepository.findAll();
        return subDivisionList.stream().map(subDivision -> mapper.map(subDivision, SubDivisionResponse.class)).toList();
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
    public String updateSubDivision(SubDivisionUpdateDTO subDivisionUpdateDTO, int subDivisionCode) {
        try{
            SubDivision subDivision = subDivisionRepository.findById(subDivisionCode)
                .orElseThrow(() -> new RuntimeException("Sub-division not found with given sub-division code"));
        BeanUtils.copyProperties(subDivisionUpdateDTO, subDivision);
        subDivision.setSubDivisionUpdatedAt(LocalDateTime.now());
        subDivisionRepository.save(subDivision);
        return "Sub Division Updated Successfully";
        }catch(Exception e){
            return "Error while updating Sub Division\n"+ e.getMessage();
        }
    }

    // Get SubDivision By active
    @Override
    public List<SubDivisionResponse> getSubDivisionByActive(boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository.findBySubDivisionActive(active);
        return subDivisionList.stream().map(subDivision -> mapper.map(subDivision, SubDivisionResponse.class)).toList();
    }

    // Get Active SubDivision By DivisionCode
    @Override
    public List<SubDivisionResponse> getActiveSubDivisionByDivisionCode(int divisionCode, boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository
                .findByDivision_DivisionCodeAndSubDivisionActive(divisionCode, active);
        List<SubDivisionResponse> subDivisionDTOList = subDivisionList.stream()
                .map(subdivision -> mapper.map(subdivision, SubDivisionResponse.class))
                .toList();
        return subDivisionDTOList;
    }

    @Override
    public List<SubDivisionCardDTO> getActiveSubDivisionCardByDivisionCode(int divisionCode, boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository
                .findByDivision_DivisionCodeAndSubDivisionActive(divisionCode, active);
        List<SubDivisionCardDTO> subDivisionCardDTOList = subDivisionList.stream()
                .map(subdivision -> mapper.map(subdivision, SubDivisionCardDTO.class))
                .toList();
        return subDivisionCardDTOList;
    }

    @Override
    public List<SubDivisionTreeDTO> getActiveSubDivisionTreeByDivisionCode(int divisionCode, boolean active) {
        List<SubDivision> subDivisionList = subDivisionRepository
                .findByDivision_DivisionCodeAndSubDivisionActive(divisionCode, active);
        List<SubDivisionTreeDTO> subDivisionTreeDTOList = subDivisionList.stream()
                .map(subdivision -> mapper.map(subdivision, SubDivisionTreeDTO.class))
                .toList();
        return subDivisionTreeDTOList;
    }

}
