package com.sm.vidyut_nigam.controller.network;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.network.FeederRequestDTO;
import com.sm.vidyut_nigam.dto.network.FeederResponseDTO;
import com.sm.vidyut_nigam.dto.network.FeederUpdateDTO;
import com.sm.vidyut_nigam.dto.network.CardStructureResponse.FeederCardDTO;
import com.sm.vidyut_nigam.service.network.FeederService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/feeder")
public class FeederController {

    private final FeederService feederService;

    @PostMapping
    public ResponseEntity<?> createFeeder(@Valid @RequestBody FeederRequestDTO feederRequestDTO) {
        try {
            FeederRequestDTO feederResponseDTO = feederService.createFeeder(feederRequestDTO);
            return ResponseEntity.ok(feederResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating feeder");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllFeeder() {
        try {
            List<FeederResponseDTO> allFeeders = feederService.getAllFeeders();
            return ResponseEntity.ok(allFeeders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching all feeders");
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getFeederById(@PathVariable int code) {
        try {
            FeederResponseDTO feederResponseDTO = feederService.getSingleFeederByCode(code);
            return ResponseEntity.ok(feederResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching feeder by code");
        }
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<?> updateFeeder(@Valid @RequestBody FeederUpdateDTO feederUpdateDTO, @PathVariable int code) {
        try {
            feederService.updateFeeder(feederUpdateDTO, code);
            return ResponseEntity.ok("Feeder updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating feeder");
        }
    }

    @PatchMapping("/delete/{code}")
    public ResponseEntity<?> deleteFeeder(@PathVariable int code) {
        try {
            feederService.deleteFeeder(code);
            return ResponseEntity.ok("Feeder deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting feeder");
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> getFeederByActive(@RequestParam boolean active) {
        try {
            List<FeederResponseDTO> allFeeders = feederService.getFeederByActive(active);
            return ResponseEntity.ok(allFeeders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching feeders by active");
        }
    }

    @GetMapping("/get-active/{subStationCode}")
    public ResponseEntity<?> getFeederBySubStationCode(@PathVariable int subStationCode) {
        try {
            List<FeederResponseDTO> allFeeders = feederService.getActiveFeederBySubStationCode(subStationCode);
            return ResponseEntity.ok(allFeeders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching feeders by sub station code");
        }
    }

    @GetMapping("/card/get-active/{subStationCode}")
    public ResponseEntity<?> getFeederCardBySubStationCode(@PathVariable int subStationCode) {
        try {
            List<FeederCardDTO> allFeeders = feederService.getActiveFeederCardBySubStationCode(subStationCode);
            return ResponseEntity.ok(allFeeders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching feeders by sub station code");
        }
    }
}
