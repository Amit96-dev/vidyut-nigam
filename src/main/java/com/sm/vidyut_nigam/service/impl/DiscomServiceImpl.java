package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(DiscomServiceImpl.class);

    // Create Discom

    @Override
    public DiscomDTO createDiscom(DiscomDTO discomDTO) {
        Discom discom = discomRepository.save(mapper.map(discomDTO, Discom.class));
        return mapper.map(discom, DiscomDTO.class);
    }

    // Get all Discom

    // @Override
    // public List<DiscomDTO> getAllDiscom() {
    // List<Discom> discomList = discomRepository.findAll();
    // List<DiscomDTO> discomDTOslist = discomList.stream().map(discom ->
    // mapper.map(discomList, DiscomDTO.class))
    // .toList();
    // return discomDTOslist;
    // }

    // Get discom by Code

    @Override
    public DiscomDTO getDiscomByCode(int discomId) {
        Discom discom = discomRepository.findById(discomId)
                .orElseThrow(() -> new RuntimeException("discom not found with given ID="));
        return mapper.map(discom, DiscomDTO.class);
    }

    // Update Discom

    @Override
    public DiscomDTO updateDiscom(int discomCode, DiscomUpdateDTO discomDTO) {
        Discom existingDiscom = discomRepository.findById(discomCode)
                .orElseThrow(() -> new RuntimeException("Discom not found with given ID."));

        logger.info("existing Discom:{}", existingDiscom);
        BeanUtils.copyProperties(discomDTO, existingDiscom);

        existingDiscom.setDiscomUpdatedAt(LocalDateTime.now());
        Discom discom1 = discomRepository.save(existingDiscom);

        return mapper.map(discom1, DiscomDTO.class);
    }

    // Delete Discom

    @Override
    public String deleteDiscom(int discomId) {
        try {
            Discom discom = discomRepository.findById(discomId)
                    .orElseThrow(() -> new RuntimeException("discom not found by given ID."));
            discom.setDiscomActive(false);
            discomRepository.save(discom);
            return "Discom deleted successfully";
        } catch (Exception e) {
            return "Some error occurred while deleting discom.";
        }
    }

    // Get Discom By Active

    @Override
    public List<DiscomDTO> getDiscomByActive(boolean active) {
        List<Discom> byActive = discomRepository.findByDiscomActive(active);
        List<DiscomDTO> discomDTOList = byActive.stream().map(a -> mapper.map(a,
                DiscomDTO.class)).toList();
        return discomDTOList;
    }

}
