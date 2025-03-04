package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.TransformerRequestDTO;
import com.sm.vidyut_nigam.dto.network.TransformerResponseDTO;
import com.sm.vidyut_nigam.dto.network.CardStructureResponse.TransformerCardDTO;

public interface TransformerService {
    String createTransformer(TransformerRequestDTO transformerRequestDTO);

    TransformerResponseDTO getSingleTransformerByCode(int transformerCode);

    List<TransformerResponseDTO> getAllTransformers();

    List<TransformerResponseDTO> getAllTransformerByFeederCode(int feederCode);

    List<TransformerCardDTO> getAllActiveTransformerCardByFeederCode(int feederCode, boolean active);

    String updateTransformer(TransformerRequestDTO transformerRequestDTO);

    List<TransformerResponseDTO> getAllTransformerByActive(boolean active);

    String deleteTransformer(int transformerCode);
}