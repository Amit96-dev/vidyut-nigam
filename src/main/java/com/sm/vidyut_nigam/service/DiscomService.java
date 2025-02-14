package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;

public interface DiscomService {
    DiscomDTO createDiscom(DiscomDTO discomDTO);
    List<DiscomDTO> getAllDiscom();
    DiscomDTO getDiscomById(int discomId);
    DiscomDTO getDiscomByCode(String discomCode);
    DiscomDTO updateDiscom(int discomId, DiscomUpdateDTO discomDTO);
    void deleteDiscom(int discomId);
    DiscomDTO updateDiscomByCode(String discomCode, DiscomUpdateDTO discomDTO);
}
