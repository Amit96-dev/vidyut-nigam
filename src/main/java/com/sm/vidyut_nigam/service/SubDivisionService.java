package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.SubDivisionDTO;
import com.sm.vidyut_nigam.dto.SubDivisionUpdateDTO;

public interface SubDivisionService {
    SubDivisionDTO createSubDivision(SubDivisionDTO subDivisionDTO);

    SubDivisionDTO getSubDivisionBySubDivisionCode(int subDivisionCode);

    List<SubDivisionDTO> getAllSubDivisions();

    SubDivisionDTO updateSubDivision(SubDivisionUpdateDTO subDivisionUpdateDTO, int subDivisionCode);

    String deactivateSubDivision(int subDivisionCode);

    List<SubDivisionDTO> getSubDivisionByActive(boolean active);

    List<SubDivisionDTO> getActiveSubDivisionByDivisionCode(int divisionCode, boolean active);
}
