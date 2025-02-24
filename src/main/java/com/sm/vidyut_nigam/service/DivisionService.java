package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.dto.DivisionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.DivisionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.DivisionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.DivisionTreeDTO;

public interface DivisionService {
    DivisionDTO createDivision(DivisionDTO divisionDTO);

    // List<DivisionDTO> getAllDivisions();

    DivisionResponse getDivisionByDivisionCode(int divisionCode);

    DivisionDTO updateDivision(DivisionUpdateDTO divisionUpdateDTO, int divisionCode);

    List<DivisionDTO> findDivisionByActive(boolean active);

    List<DivisionDTO> findActiveDivisionByCircleCode(int circleCode, boolean active);

    List<DivisionCardDTO> findActiveDivisionCardByCircleCode(int circleCode, boolean active);

    List<DivisionTreeDTO> findActiveDivisionTreeByCircleCode(int circleCode, boolean active);

    String deleteDivision(int divisionCode);
}
