package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.dto.DivisionUpdateDTO;

public interface DivisionService {
    DivisionDTO createDivision(DivisionDTO divisionDTO);
    List<DivisionDTO> getAllDivisions();
    DivisionDTO getDivisionByDivisionCode(int divisionCode);
    DivisionDTO updateDivision(DivisionUpdateDTO divisionUpdateDTO, int divisionCode);
    List<DivisionDTO> findDivisionByActive(boolean active);
    String deleteDivision(int divisionCode);
}
