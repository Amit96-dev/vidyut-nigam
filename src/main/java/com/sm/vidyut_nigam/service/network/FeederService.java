package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.FeederRequestDTO;
import com.sm.vidyut_nigam.dto.network.FeederResponseDTO;
import com.sm.vidyut_nigam.dto.network.FeederUpdateDTO;
import com.sm.vidyut_nigam.dto.network.CardStructureResponse.FeederCardDTO;

public interface FeederService {
    String createFeeder(FeederRequestDTO feederRequestDTO);

    List<FeederResponseDTO> getAllFeeders();

    List<FeederResponseDTO> getFeederByActive(boolean active);

    List<FeederResponseDTO> getActiveFeederBySubStationCode(int subStationCode, boolean active);

    List<FeederCardDTO> getActiveFeederCardBySubStationCode(int subStationCode, boolean active);

    String updateFeeder(FeederUpdateDTO feederUpdateDTO, int feederCode);

    String deleteFeeder(int feederCode);

    FeederResponseDTO getSingleFeederByCode(int feederCode);
}
