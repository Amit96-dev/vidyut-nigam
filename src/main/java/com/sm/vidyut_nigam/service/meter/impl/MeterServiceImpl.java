package com.sm.vidyut_nigam.service.meter.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;
import com.sm.vidyut_nigam.entity.consumer.Consumer;
import com.sm.vidyut_nigam.entity.meter.Meter;
import com.sm.vidyut_nigam.repository.consumer.ConsumerRepository;
import com.sm.vidyut_nigam.repository.meter.MeterRepository;
import com.sm.vidyut_nigam.service.meter.MeterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeterServiceImpl implements MeterService {

    private final MeterRepository meterRepository;

    private final ModelMapper mapper;

    private final ConsumerRepository consumerRepository;

    @Override
    public String createMeter(MeterRequestDTO meterRequestDTO) {
        // Fetch the existing consumer
        Optional<Consumer> consumerOptional = consumerRepository.findById(meterRequestDTO.getMeterConsumerId());
        if (consumerOptional.isEmpty()) {
            return "Consumer not found";
        }

        try {
            // Map DTO to Meter entity
            Meter meter = mapper.map(meterRequestDTO, Meter.class);

            // Set the existing consumer reference
            meter.setMeterConsumerId(consumerOptional.get());

            // Save the Meter entity
            meterRepository.save(meter);

            return "Meter created successfully";
        } catch (Exception e) {
            e.printStackTrace(); // Log the error properly
            return "Error creating meter\n" + e.getMessage();
        }
    }

}
