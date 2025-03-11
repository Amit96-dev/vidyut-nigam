package com.sm.vidyut_nigam.service.system_configuration.charge.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.system_configuration.charge.ChargeDTO;
import com.sm.vidyut_nigam.dto.system_configuration.charge.ChargeResponseDTO;
import com.sm.vidyut_nigam.entity.system_configuration.Charge;
import com.sm.vidyut_nigam.repository.system_configuration.ChargeRepository;
import com.sm.vidyut_nigam.service.system_configuration.charge.ChargeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChargeServiceImpl implements ChargeService {

    private final ChargeRepository chargeRepository;

    @Override
    public String createCharge(ChargeDTO chargeDTO) {
        try {
            Charge charge = new Charge();
            BeanUtils.copyProperties(chargeDTO, charge);
            charge.setChargeStatus(true);
            chargeRepository.save(charge);
            return "Charge created successfully";
        } catch (Exception e) {
            return "Error creating charge: " + e.getMessage();
        }
    }

    @Override
    public List<ChargeResponseDTO> showAllCharges() {
        try {
            List<Charge> charges = chargeRepository.findAll();
            List<ChargeResponseDTO> chargeDTOs = charges.stream().map(charge -> {
                ChargeResponseDTO chargeDTO = new ChargeResponseDTO();
                BeanUtils.copyProperties(charge, chargeDTO);
                return chargeDTO;
            }).toList();
            return chargeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch meters: " + e.getMessage(), e);
        }
    }

}
