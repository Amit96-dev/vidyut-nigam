package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.DiscomCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.DiscomResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.DiscomTreeDTO;

public interface DiscomService {
    DiscomDTO createDiscom(DiscomDTO discomDTO);

    // List<DiscomDTO> getAllDiscom();
    DiscomResponse getDiscomByCode(int discomCode);

    DiscomDTO updateDiscom(int discomCode, DiscomUpdateDTO discomDTO);

    String deleteDiscom(int discomCode);

    List<DiscomResponse> getDiscomByActive(boolean active);

    List<DiscomCardDTO> getDiscomCardByActive(boolean active);

    List<DiscomTreeDTO> getDiscomTreeByActive(boolean active);
}
