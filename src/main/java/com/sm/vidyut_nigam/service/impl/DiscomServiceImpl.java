package com.sm.vidyut_nigam.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.DiscomCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.DiscomResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.DiscomTreeDTO;
import com.sm.vidyut_nigam.entity.Discom;
import com.sm.vidyut_nigam.repository.DiscomRepository;
import com.sm.vidyut_nigam.service.DiscomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiscomServiceImpl implements DiscomService {

    private final DiscomRepository discomRepository;

    private final ModelMapper mapper;

    // Create Discom

    @Override
    public String createDiscom(DiscomDTO discomDTO) {
        long count = discomRepository.count();
        if (count > 9) {
            throw new RuntimeException("AAU DISCOM CREATE KARIPARI BANI");
        }
        try {
            discomDTO.setDiscomCode((int) count + 1);
            discomRepository.save(mapper.map(discomDTO, Discom.class));
            return "Discom Created Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
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
    public DiscomResponse getDiscomByCode(int discomId) {
        Discom discom = discomRepository.findById(discomId)
                .orElseThrow(() -> new RuntimeException("discom not found with given ID="));
        return mapper.map(discom, DiscomResponse.class);
    }

    // Update Discom

    @Override
    public String updateDiscom(int discomCode, DiscomUpdateDTO discomDTO) {
        try {
            Discom existingDiscom = discomRepository.findById(discomCode)
                    .orElseThrow(() -> new RuntimeException("Discom not found with given ID."));

            BeanUtils.copyProperties(discomDTO, existingDiscom);

            existingDiscom.setDiscomUpdatedAt(LocalDateTime.now());
            discomRepository.save(existingDiscom);

            return "Discom Updated Successfully";
        } catch (Exception e) {
            return "Error in Updating Discom\n" + e.getMessage();
        }
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
    public List<DiscomResponse> getDiscomByActive(boolean active) {
        List<Discom> byActive = discomRepository.findByDiscomActive(active);
        List<DiscomResponse> discomDTOList = byActive.stream().map(a -> mapper.map(a, DiscomResponse.class)).toList();
        return discomDTOList;
    }

    @Override
    public List<DiscomCardDTO> getDiscomCardByActive(boolean active) {
        List<Discom> byActive = discomRepository.findByDiscomActive(active);
        List<DiscomCardDTO> discomCardDTOList = byActive.stream().map(a -> mapper.map(a, DiscomCardDTO.class)).toList();
        return discomCardDTOList;
    }

    @Override
    public List<DiscomTreeDTO> getDiscomTreeByActive(boolean active) {
        List<Discom> byActive = discomRepository.findByDiscomActive(active);
        List<DiscomTreeDTO> discomTreeDTOList = byActive.stream().map(a -> mapper.map(a, DiscomTreeDTO.class)).toList();
        return discomTreeDTOList;
    }

}
