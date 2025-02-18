package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;

public interface CircleService {
    CircleDTO createCircle(CircleDTO circleDTO);

    List<CircleDTO> getAllCircles(int discomCode);

    CircleDTO getCircleByCode(int circleCode, int discomCode);

    CircleDTO updateCircle(int circleCode, int discomeCode, CircleUpdateDTO circleDTO);

    List<CircleDTO> getCircleByActive(boolean active);

    List<CircleDTO> getActiveCircleByDiscomCode(int discomCode, boolean active);

    String deleteCircle(int circleCode, int discomCode);
}
