package com.sm.vidyut_nigam.service.network.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.network.TransformerRequestDTO;
import com.sm.vidyut_nigam.dto.network.TransformerResponseDTO;
import com.sm.vidyut_nigam.entity.network.Transformer;
import com.sm.vidyut_nigam.repository.network.TransformerRepository;
import com.sm.vidyut_nigam.service.network.TransformerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransformerServiceImpl implements TransformerService {

    private final TransformerRepository transformerRepository;
    private final ModelMapper mapper;

    @Override
    public TransformerResponseDTO createTransformer(TransformerRequestDTO transformerRequestDTO) {
        int code = transformerRepository.countByFeeder_FeederCode(transformerRequestDTO.getTransformerCode());
        String transformerCode = Integer.toString(transformerRequestDTO.getFeeder()) + Integer.toString(code + 1);
        transformerRequestDTO.setFeeder(Integer.parseInt(transformerCode));
        Transformer transformer = transformerRepository.save(mapper.map(transformerRequestDTO, Transformer.class));
        return mapper.map(transformer, TransformerResponseDTO.class);
    }

    @Override
    public TransformerResponseDTO getSingleTransformerByCode(int transformerCode) {
        Transformer transformer = transformerRepository.findById(transformerCode)
                .orElseThrow(() -> new RuntimeException("Transformer not found with given ID"));
        return mapper.map(transformer, TransformerResponseDTO.class);
    }

    @Override
    public List<TransformerResponseDTO> getAllTransformers() {
        List<Transformer> transformers = transformerRepository.findAll();
        return transformers.stream().map(transformer -> mapper.map(transformer, TransformerResponseDTO.class)).toList();
    }

    @Override
    public List<TransformerResponseDTO> getAllTransformerByFeederCode(int feederCode) {
        List<Transformer> transformerList = transformerRepository.findByFeeder_FeederCode(feederCode);
        return transformerList.stream().map(transformer -> mapper.map(transformer, TransformerResponseDTO.class))
                .toList();
    }

    @Override
    public String updateTransformer(TransformerRequestDTO transformerRequestDTO) {
        Transformer transformer = transformerRepository.findById(transformerRequestDTO.getTransformerCode())
                .orElseThrow(() -> new RuntimeException("Transformer not found with given ID"));
        BeanUtils.copyProperties(transformerRequestDTO, transformer);
        transformer.setTransformerUpdatedAt(LocalDateTime.now());
        transformerRepository.save(transformer);
        return "Transformer updated successfully";
    }

    @Override
    public List<TransformerResponseDTO> getAllTransformerByActive(boolean active) {
        List<Transformer> transformerList = transformerRepository.findByTransformerActive(active);
        return transformerList.stream().map(transformer -> mapper.map(transformer, TransformerResponseDTO.class))
                .toList();
    }

    @Override
    public String deleteTransformer(int transformerCode) {
        Transformer transformer = transformerRepository.findById(transformerCode)
                .orElseThrow(() -> new RuntimeException("Transformer not found with given ID"));
        transformer.setTransformerActive(false);
        return "Transformer deleted successfully";
    }

}
