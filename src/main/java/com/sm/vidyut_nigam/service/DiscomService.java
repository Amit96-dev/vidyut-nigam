package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;

public interface DiscomService {
    DiscomDTO createDiscom(DiscomDTO discomDTO);

    // List<DiscomDTO> getAllDiscom();
    DiscomDTO getDiscomByCode(int discomCode);

    DiscomDTO updateDiscom(int discomCode, DiscomUpdateDTO discomDTO);

    String deleteDiscom(int discomCode);

    List<DiscomDTO> getDiscomByActive(boolean active);
}
