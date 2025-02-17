package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.CircleDTO;

public interface CircleService {
    CircleDTO createCircle(CircleDTO circleDTO);
    List<CircleDTO> getAllCircles();
}
