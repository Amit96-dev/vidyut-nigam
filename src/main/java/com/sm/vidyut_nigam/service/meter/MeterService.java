package com.sm.vidyut_nigam.service.meter;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;
import com.sm.vidyut_nigam.dto.meter.MeterResponseDTO;

public interface MeterService {
    String createMeter(MeterRequestDTO meterRequestDTO);

    String uploadMeters(MultipartFile file);

    List<MeterResponseDTO> showAllMeters();
}
