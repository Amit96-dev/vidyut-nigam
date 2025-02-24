package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.SubStationDTO;

public interface SubStationService {
    SubStationDTO createSubStation(SubStationDTO subStationDTO);
    SubStationDTO updateSubStation(SubStationDTO subStationDTO, int subStationCode);
    List<SubStationDTO> getAllSubStations();
    SubStationDTO getSingleSubStationByCode(int subStationCode);
    String deleteSubStation(int subStationCode);
    List<SubStationDTO> getSubStationByActive(boolean active);
    List<SubStationDTO> searchBySubStationName(String name);
}
