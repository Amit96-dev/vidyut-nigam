package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.SubStationRequestDTO;
import com.sm.vidyut_nigam.dto.network.SubStationResponseDTO;
import com.sm.vidyut_nigam.dto.network.SubStationUpdateDTO;
import com.sm.vidyut_nigam.dto.network.CardStructureResponse.SubStationCardDTO;

public interface SubStationService {
    SubStationRequestDTO createSubStation(SubStationRequestDTO subStationDTO);

    SubStationUpdateDTO updateSubStation(SubStationUpdateDTO subStationUpdateDTO, int subStationCode);

    List<SubStationResponseDTO> getAllSubStations();

    SubStationRequestDTO getSingleSubStationByCode(int subStationCode);

    String deleteSubStation(int subStationCode);

    List<SubStationRequestDTO> getSubStationByActive(boolean active);

    List<SubStationCardDTO> getSubStationCardByActive(boolean active);

    List<SubStationRequestDTO> searchBySubStationName(String name);
}
