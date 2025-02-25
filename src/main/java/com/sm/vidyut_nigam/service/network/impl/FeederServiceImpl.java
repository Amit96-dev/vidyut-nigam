package com.sm.vidyut_nigam.service.network.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.network.FeederRequestDTO;
import com.sm.vidyut_nigam.dto.network.FeederResponseDTO;
import com.sm.vidyut_nigam.dto.network.FeederUpdateDTO;
import com.sm.vidyut_nigam.entity.network.Feeder;
import com.sm.vidyut_nigam.repository.network.FeederRepository;
import com.sm.vidyut_nigam.service.network.FeederService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FeederServiceImpl implements FeederService {

    private final FeederRepository feederRepository;
    private ModelMapper mapper;

    @Override
    public FeederRequestDTO createFeeder(FeederRequestDTO feederRequestDTO) {
        int code = feederRepository.countBySubStation_SubStationCode(feederRequestDTO.getFeederCode());
        String feederCode = Integer.toString(feederRequestDTO.getSubStationCode()) + Integer.toString(code + 1);
        feederRequestDTO.setFeederCode(Integer.parseInt(feederCode));
        Feeder feeder = feederRepository.save(mapper.map(feederRequestDTO, Feeder.class));
        return mapper.map(feeder, FeederRequestDTO.class);
    }

    @Override
    public List<FeederResponseDTO> getAllFeeders() {
        List<Feeder> feeders = feederRepository.findAll();
        return feeders.stream().map(feeder -> mapper.map(feeder, FeederResponseDTO.class)).toList();
    }

    @Override
    public List<FeederResponseDTO> getFeederByActive(boolean active) {
        List<Feeder> feederByActive = feederRepository.findByFeederActive(active);
        List<FeederResponseDTO> feederResponseDTOList = feederByActive.stream().map(feeder -> mapper.map(feeder, FeederResponseDTO.class)).toList();
        return feederResponseDTOList;
    }

    @Override
    public List<FeederResponseDTO> getActiveFeederBySubStationCode(int subStationCode) {
        List<Feeder> FeederList = feederRepository.findBySubStation_SubStationCode(subStationCode);
        return FeederList.stream().map(feeder -> mapper.map(feeder, FeederResponseDTO.class)).toList();
    }

    @Override
    public String updateFeeder(FeederUpdateDTO feederUpdateDTO, int feederCode) {
        Feeder feeder = feederRepository.findById(feederCode).orElseThrow(()-> new RuntimeException("Feeder not found with given code"));
        BeanUtils.copyProperties(feederUpdateDTO, feeder);
        feeder.setFeederUpdatedAt(LocalDateTime.now());
        feederRepository.save(feeder);
        return "Feeder Updated Successfully";
    }

    @Override
    public String deleteFeeder(int feederCode) {
        Feeder feeder = feederRepository.findById(feederCode).orElseThrow(()-> new RuntimeException("Feeder not found with given code"));
        feeder.setFeederActive(false);
        return "Feeder Deleted Successfully";
    }

    @Override
    public FeederResponseDTO getSingleFeederByCode(int feederCode) {
        Feeder feeder = feederRepository.findById(feederCode).orElseThrow(()-> new RuntimeException("Feeder not found with given code"));
        return mapper.map(feeder, FeederResponseDTO.class);
    }

}
