package com.sm.vidyut_nigam.controller.system_configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.system_configuration.charge.ChargeDTO;
import com.sm.vidyut_nigam.service.system_configuration.charge.ChargeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/charge")
@RequiredArgsConstructor
public class ChargeController {

    private final ChargeService chargeService;

    @PostMapping
    public ResponseEntity<?> createCharge(@RequestBody ChargeDTO chargeDTO) {
        try {
            String res = chargeService.createCharge(chargeDTO);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Fetch all charges
    @GetMapping
    public ResponseEntity<?> showAllCharges() {
        try {
            return ResponseEntity.ok(chargeService.showAllCharges());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
