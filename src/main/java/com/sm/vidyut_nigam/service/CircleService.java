package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;

public interface CircleService {
    CircleDTO createCircle(CircleDTO circleDTO);

    List<CircleDTO> getAllCirclesByDiscomCode(int discomCode);

    CircleDTO getCircleByCode(int circleCode);

    CircleDTO updateCircle(int circleCode, CircleUpdateDTO circleDTO);

    List<CircleDTO> getCircleByActive(boolean active);

    List<CircleDTO> getActiveCircleByDiscomCode(int discomCode, boolean active);

    String deleteCircle(int circleCode);
}
