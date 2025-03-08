package com.sm.vidyut_nigam.service.meter;

import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;

public interface MeterService {
    String createMeter(MeterRequestDTO meterRequestDTO);

    String uploadMeters(MultipartFile file);
}
