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
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.service.DiscomService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/discom")
public class DiscomController {

    public final DiscomService discomService;

    Logger logger = LoggerFactory.getLogger(DiscomController.class);

    @PostMapping
    public ResponseEntity<DiscomDTO> createDiscom(@RequestBody DiscomDTO discomDTO) {
        try {
            LocalDateTime currentTime = LocalDateTime.now();
            discomDTO.setCreatedAt(currentTime);
            DiscomDTO discom = discomService.createDiscom(discomDTO);
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while creating Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("getSingle/{id}")
    public ResponseEntity<DiscomDTO> getDiscomById(@PathVariable int id) {
        DiscomDTO discomById = discomService.getDiscomById(id);
        return ResponseEntity.ok(discomById);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<DiscomDTO> updateDiscom(@RequestBody DiscomUpdateDTO discomDTO, @PathVariable int id) {
        try {
            DiscomDTO discom = discomService.updateDiscom(id, discomDTO);
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while updating Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscom(@PathVariable int id) {
        discomService.deleteDiscom(id);
        return new ResponseEntity<>("discom deleted successfully by the given id", HttpStatus.OK);
    }

}