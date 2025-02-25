package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.FeederRequestDTO;
import com.sm.vidyut_nigam.dto.network.FeederResponseDTO;
import com.sm.vidyut_nigam.dto.network.FeederUpdateDTO;

public interface FeederService {
    FeederRequestDTO createFeeder(FeederRequestDTO feederRequestDTO);
    List<FeederResponseDTO> getAllFeeders();
    List<FeederResponseDTO> getFeederByActive(boolean active);
    List<FeederResponseDTO> getActiveFeederBySubStationCode(int subStationCode);
    String updateFeeder(FeederUpdateDTO feederUpdateDTO, int feederCode);
    String deleteFeeder(int feederCode);
    FeederResponseDTO getSingleFeederByCode(int feederCode);
}
