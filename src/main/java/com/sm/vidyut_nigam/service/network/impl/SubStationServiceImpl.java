package com.sm.vidyut_nigam.service.network.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.network.SubStationRequestDTO;
import com.sm.vidyut_nigam.dto.network.SubStationResponseDTO;
import com.sm.vidyut_nigam.dto.network.SubStationUpdateDTO;
import com.sm.vidyut_nigam.entity.network.SubStation;
import com.sm.vidyut_nigam.repository.network.SubStationRepository;
import com.sm.vidyut_nigam.service.network.SubStationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubStationServiceImpl implements SubStationService{

    private final SubStationRepository subStationRepository;
    private final ModelMapper mapper;

    // Create Sub-Station
    @Override
    public SubStationRequestDTO createSubStation(SubStationRequestDTO subStationDTO) {
        SubStation subStation = subStationRepository.save(mapper.map(subStationDTO, SubStation.class));
        return mapper.map(subStation, SubStationRequestDTO.class);
    }

    // Update Sub-Station
    @Override
    public SubStationUpdateDTO updateSubStation(SubStationUpdateDTO subStationUpdateDTO, int subStationCode) {
        SubStation subStation = subStationRepository.findById(subStationCode).orElseThrow(()-> new RuntimeException("Substation not found with given code"));
        BeanUtils.copyProperties(subStationUpdateDTO, subStation);
        subStation.setSubStationUpdatedDt(LocalDateTime.now());
        subStation = subStationRepository.save(subStation);
        return mapper.map(subStation, SubStationUpdateDTO.class);
    }

    // Get All SubStations
    @Override
    public List<SubStationResponseDTO> getAllSubStations() {
        List<SubStation> subStationList = subStationRepository.findAll();
        return subStationList.stream().map(subStation -> mapper.map(subStation, SubStationResponseDTO.class)).toList();
    }

    // Get Single Sub-Station
    @Override
    public SubStationRequestDTO getSingleSubStationByCode(int subStationCode) {
        SubStation subStation = subStationRepository.findById(subStationCode).orElseThrow(()-> new RuntimeException("Substation not found with given code"));
        return mapper.map(subStation, SubStationRequestDTO.class);
    }

    // Delete Sub-Station
    @Override
    public String deleteSubStation(int subStationCode) {
        SubStation subStation = subStationRepository.findById(subStationCode).orElseThrow(()->new RuntimeException("Substation not found with given code"));
        subStation.setSubStationActive(false);
        subStationRepository.save(subStation);
        return "Substation deleted successfully";
    }

    // Get all active substations
    @Override
    public List<SubStationRequestDTO> getSubStationByActive(boolean active) {
        List<SubStation> bySubStationActive = subStationRepository.findBySubStationActive(active);
        List<SubStationRequestDTO> subStationDTOList = bySubStationActive.stream().map(subStation -> mapper.map(subStation, SubStationRequestDTO.class)).toList();
        return subStationDTOList;
    }

    // Search SubStation by name
    @Override
    public List<SubStationRequestDTO> searchBySubStationName(String name) {
        List<SubStation> subStationList = subStationRepository.findBySubStationNameContainingIgnoreCase(name);
        return subStationList.stream().map(subStation -> mapper.map(subStation, SubStationRequestDTO.class)).toList();
    }
    
}
