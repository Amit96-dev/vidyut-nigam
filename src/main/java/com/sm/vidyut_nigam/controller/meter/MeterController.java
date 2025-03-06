package com.sm.vidyut_nigam.controller.meter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;
import com.sm.vidyut_nigam.service.meter.MeterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meter")
public class MeterController {

    private final MeterService meterService;

    @PostMapping
    public ResponseEntity<?> createMeter(@RequestBody MeterRequestDTO meterRequestDTO) {
        try {
            String res = meterService.createMeter(meterRequestDTO);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
