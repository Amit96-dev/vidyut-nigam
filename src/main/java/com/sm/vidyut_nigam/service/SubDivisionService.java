package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.SubDivisionDTO;
import com.sm.vidyut_nigam.dto.SubDivisionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.SubDivisionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.SubDivisionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.SubDivisionTreeDTO;

public interface SubDivisionService {
    String createSubDivision(SubDivisionDTO subDivisionDTO);

    SubDivisionResponse getSubDivisionBySubDivisionCode(int subDivisionCode);

    List<SubDivisionResponse> getAllSubDivisions();

    String updateSubDivision(SubDivisionUpdateDTO subDivisionUpdateDTO, int subDivisionCode);

    String deactivateSubDivision(int subDivisionCode);

    List<SubDivisionResponse> getSubDivisionByActive(boolean active);

    List<SubDivisionResponse> getActiveSubDivisionByDivisionCode(int divisionCode, boolean active);

    List<SubDivisionCardDTO> getActiveSubDivisionCardByDivisionCode(int divisionCode, boolean active);

    List<SubDivisionTreeDTO> getActiveSubDivisionTreeByDivisionCode(int divisionCode, boolean active);
}
