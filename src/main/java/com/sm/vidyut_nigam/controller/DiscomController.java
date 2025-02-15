package com.sm.vidyut_nigam.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.service.DiscomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/discom")
public class DiscomController {

    public final DiscomService discomService;

    Logger logger = LoggerFactory.getLogger(DiscomController.class);

    // Create Discom

    @PostMapping
    public ResponseEntity<DiscomDTO> createDiscom(@Valid @RequestBody DiscomDTO discomDTO) {
        try {
            // LocalDateTime currentTime = LocalDateTime.now();
            // discomDTO.setCreatedAt(currentTime);

            DiscomDTO discom = discomService.createDiscom(discomDTO);
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while creating Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Get Discom By discomCode

    @GetMapping("getSingle/{discomCode}")
    public ResponseEntity<DiscomDTO> getDiscomByDiscomCode(@PathVariable int discomCode) {
        DiscomDTO discomById = discomService.getDiscomByCode(discomCode);
        return ResponseEntity.ok(discomById);
    }

    // Get all Discom

    @GetMapping
    public ResponseEntity<List<DiscomDTO>> getAllDiscom() {
        try {
            List<DiscomDTO> discom = discomService.getAllDiscom();
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while getting all Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Update Discom

    @PutMapping("/{discomCode}")
    public ResponseEntity<DiscomDTO> updateDiscom(@Valid @RequestBody DiscomUpdateDTO discomUpdateDTO, @PathVariable int discomCode) {
        try {
            DiscomDTO discom = discomService.updateDiscom(discomCode, discomUpdateDTO);
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while updating Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete Discom
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscom(@PathVariable int id) {
        discomService.deleteDiscom(id);
        return new ResponseEntity<>("discom deleted successfully by the given id", HttpStatus.OK);
    }

    // Get Discom by Active

    @GetMapping("/active")
    public ResponseEntity<List<DiscomDTO>> getDiscomByActive(@RequestParam boolean active) {
        try {
            List<DiscomDTO> discoms = discomService.getDiscomByActive(active);
            return ResponseEntity.ok(discoms);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }
}