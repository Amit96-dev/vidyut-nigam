package com.sm.vidyut_nigam.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.entity.Discom;
import com.sm.vidyut_nigam.repository.DiscomRepository;
import com.sm.vidyut_nigam.service.DiscomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiscomServiceImpl implements DiscomService {

    private final DiscomRepository discomRepository;

    private final ModelMapper mapper;

    @Override
    public DiscomDTO createDiscom(DiscomDTO discomDTO) {
        Discom discom = discomRepository.save(mapper.map(discomDTO, Discom.class));
        return mapper.map(discom, DiscomDTO.class);
    }

    @Override
    public List<DiscomDTO> getAllDiscom() {
        List<Discom> discomList = discomRepository.findAll();
        List<DiscomDTO> discomDTOslist = discomList.stream().map(discom -> mapper.map(discomList, DiscomDTO.class))
                .toList();
        return discomDTOslist;
    }

    @Override
    public DiscomDTO getDiscomById(int discomId) {
        Discom discom = discomRepository.findById(discomId)
                .orElseThrow(() -> new RuntimeException("discom not found with given ID."));
        return mapper.map(discom, DiscomDTO.class);
    }

    @Override
    public DiscomDTO getDiscomByCode(String discomCode) {
        Discom byDiscomCode = discomRepository.findByDiscomCode(discomCode);
        return mapper.map(byDiscomCode, DiscomDTO.class);
    }

    @Override
    public DiscomDTO updateDiscom(int discomId, DiscomUpdateDTO discomDTO) {
        Discom existingDiscom = discomRepository.findById(discomId)
                .orElseThrow(() -> new RuntimeException("Discom not found with given ID."));
        
        BeanUtils.copyProperties(discomDTO, existingDiscom);

        Discom discom1 = discomRepository.save(existingDiscom);
        return mapper.map(discom1, DiscomDTO.class);
    }

    @Override
    public void deleteDiscom(int discomId) {
        Discom discom = discomRepository.findById(discomId).orElseThrow(()->new RuntimeException("discom not found by given ID."));
        discomRepository.delete(discom);
    }

    @Override
    public DiscomDTO updateDiscomByCode(String discomCode, DiscomUpdateDTO discomDTO) {
        Discom existingDiscomByDiscomCode = discomRepository.findByDiscomCode(discomCode);
        BeanUtils.copyProperties(discomDTO, existingDiscomByDiscomCode);
        discomRepository.save(existingDiscomByDiscomCode);
        return mapper.map(existingDiscomByDiscomCode, DiscomDTO.class);
    }

}
