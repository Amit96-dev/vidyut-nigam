package com.sm.vidyut_nigam.service.network.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.network.SubStationDTO;
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
    public SubStationDTO createSubStation(SubStationDTO subStationDTO) {
        SubStation subStation = subStationRepository.save(mapper.map(subStationDTO, SubStation.class));
        return mapper.map(subStation, SubStationDTO.class);
    }

    // Update Sub-Station
    @Override
    public SubStationDTO updateSubStation(SubStationDTO subStationDTO, int subStationCode) {
        SubStation subStation = subStationRepository.findById(subStationCode).orElseThrow(()-> new RuntimeException("Substation not found with given code"));
        BeanUtils.copyProperties(subStationDTO, subStation);
        subStation.setSubStationUpdatedDt(LocalDateTime.now());
        subStation = subStationRepository.save(subStation);
        return mapper.map(subStation, SubStationDTO.class);
    }

    // Get All SubStations
    @Override
    public List<SubStationDTO> getAllSubStations() {
        List<SubStation> subStationList = subStationRepository.findAll();
        return subStationList.stream().map(subStation -> mapper.map(subStation, SubStationDTO.class)).toList();
    }

    // Get Single Sub-Station
    @Override
    public SubStationDTO getSingleSubStationByCode(int subStationCode) {
        SubStation subStation = subStationRepository.findById(subStationCode).orElseThrow(()-> new RuntimeException("Substation not found with given code"));
        return mapper.map(subStation, SubStationDTO.class);
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
    public List<SubStationDTO> getSubStationByActive(boolean active) {
        List<SubStation> bySubStationActive = subStationRepository.findBySubStationActive(active);
        List<SubStationDTO> subStationDTOList = bySubStationActive.stream().map(subStation -> mapper.map(subStation, SubStationDTO.class)).toList();
        return subStationDTOList;
    }

    // Search SubStation by name
    @Override
    public List<SubStationDTO> searchBySubStationName(String name) {
        List<SubStation> subStationList = subStationRepository.findBySubStationNameContaining(name);
        return subStationList.stream().map(subStation -> mapper.map(subStation, SubStationDTO.class)).toList();
    }
    
}
