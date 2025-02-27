package com.sm.vidyut_nigam.service;

import java.util.List;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.CircleCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.CircleResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.CircleTreeDTO;

public interface CircleService {
    String createCircle(CircleDTO circleDTO);

    List<CircleResponse> getAllCirclesByDiscomCode(int discomCode);

    CircleResponse getCircleByCode(int circleCode);

    String updateCircle(int circleCode, CircleUpdateDTO circleDTO);

    List<CircleResponse> getCircleByActive(boolean active);

    List<CircleResponse> getActiveCircleByDiscomCode(int discomCode, boolean active);

    List<CircleCardDTO> getActiveCircleCardByDiscomCode(int discomCode, boolean active);

    List<CircleTreeDTO> getActiveCircleTreeByDiscomCode(int discomCode, boolean active);

    String deleteCircle(int circleCode);
}
