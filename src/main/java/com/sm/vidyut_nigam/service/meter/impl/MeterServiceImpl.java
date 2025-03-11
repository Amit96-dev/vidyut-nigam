package com.sm.vidyut_nigam.service.meter.impl;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;
import com.sm.vidyut_nigam.dto.meter.MeterResponseDTO;
import com.sm.vidyut_nigam.entity.consumer.Consumer;
import com.sm.vidyut_nigam.entity.meter.Meter;
import com.sm.vidyut_nigam.repository.consumer.ConsumerRepository;
import com.sm.vidyut_nigam.repository.meter.MeterRepository;
import com.sm.vidyut_nigam.service.meter.MeterService;
import com.sm.vidyut_nigam.service.meter.excel.MeterExcelHelper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeterServiceImpl implements MeterService {

    private final MeterRepository meterRepository;

    private final ModelMapper mapper;

    private final ConsumerRepository consumerRepository;

    @Override
    public String createMeter(MeterRequestDTO meterRequestDTO) {
        try {
            Meter meter = mapper.map(meterRequestDTO, Meter.class);

            if (meterRequestDTO.getMeterConsumerId() != null) {
                // Fetch the existing consumer if the ID is provided
                Optional<Consumer> consumerOptional = consumerRepository.findById(meterRequestDTO.getMeterConsumerId());

                if (consumerOptional.isPresent()) {
                    // Set the existing consumer reference
                    meter.setMeterConsumerId(consumerOptional.get());
                } else {
                    return "Consumer not found";
                }
            }

            meterRepository.save(meter);

            return "Meter created successfully";
        } catch (Exception e) {
            e.printStackTrace(); // Log the error properly
            return "Error creating meter: " + e.getMessage();
        }
    }

    @Override
    @Transactional
    public String uploadMeters(MultipartFile file) {
        if (!MeterExcelHelper.hasExcelFormat(file)) {
            throw new IllegalArgumentException("Invalid file format. Please upload an Excel file.");
        }

        try {
            List<MeterRequestDTO> meterDTOs = MeterExcelHelper.excelToMeters(file.getInputStream());

            for (MeterRequestDTO dto : meterDTOs) {
                Meter meter = new Meter();
                BeanUtils.copyProperties(dto, meter);

                if (dto.getMeterConsumerId() != null && !dto.getMeterConsumerId().trim().isEmpty()) {
                    Optional<Consumer> consumer = consumerRepository.findById(dto.getMeterConsumerId());

                    if (consumer.isPresent()) {
                        meter.setMeterConsumerId(consumer.get());
                    }
                }

                // Allow meters without a consumer
                meterRepository.save(meter);
            }
            return "Meter data uploaded successfully.";

        } catch (IOException e) {
            throw new RuntimeException("Error reading the Excel file: " + e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload meter data: " + e.getMessage(), e);
        }
    }

    @Override
    public List<MeterResponseDTO> showAllMeters() {
        try {
            List<Meter> meters = meterRepository.findAll();

            // Convert List<Meter> to List<MeterResponseDTO>
            return meters.stream().map(meter -> {
                MeterResponseDTO meterResponseDTO = new MeterResponseDTO();
                BeanUtils.copyProperties(meter, meterResponseDTO);

                // Convert Consumer ID to String (if needed)
                if (meter.getMeterConsumerId() != null) {
                    meterResponseDTO.setMeterConsumerId(meter.getMeterConsumerId().getConsumerAccountNo());
                }

                return meterResponseDTO;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch meters: " + e.getMessage(), e);
        }
    }

}
