package com.sm.vidyut_nigam.service.network;

import java.util.List;

import com.sm.vidyut_nigam.dto.network.TransformerRequestDTO;
import com.sm.vidyut_nigam.dto.network.TransformerResponseDTO;

public interface TransformerService {
    TransformerResponseDTO createTransformer(TransformerRequestDTO transformerRequestDTO);
    TransformerResponseDTO getSingleTransformerByCode(int transformerCode);
    List<TransformerResponseDTO> getAllTransformers();
    List<TransformerResponseDTO> getAllTransformerByFeederCode(int feederCode);
    String updateTransformer(TransformerRequestDTO transformerRequestDTO);
    List<TransformerResponseDTO> getAllTransformerByActive(boolean active);
    String deleteTransformer(int transformerCode);
}