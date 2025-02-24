package com.sm.vidyut_nigam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.DiscomDTO;
import com.sm.vidyut_nigam.dto.DiscomUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.DiscomCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.DiscomResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.DiscomTreeDTO;
import com.sm.vidyut_nigam.service.DiscomService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")

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
    public ResponseEntity<?> getDiscomByDiscomCode(@PathVariable int discomCode) {
        try {
            DiscomResponse discomById = discomService.getDiscomByCode(discomCode);
            return ResponseEntity.ok(discomById);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + discomCode);
        }
    }

    // Get all Discom

    // @GetMapping
    // public ResponseEntity<List<DiscomDTO>> getAllDiscom() {
    // try {
    // List<DiscomDTO> discom = discomService.getAllDiscom();
    // return ResponseEntity.ok(discom);
    // } catch (Exception e) {
    // logger.error("Error while getting all Discom", e);
    // return ResponseEntity.badRequest().build();
    // }
    // }

    // Update Discom

    @PutMapping("/{discomCode}")
    public ResponseEntity<DiscomDTO> updateDiscom(@Valid @RequestBody DiscomUpdateDTO discomUpdateDTO,
            @PathVariable int discomCode) {
        try {
            DiscomDTO discom = discomService.updateDiscom(discomCode, discomUpdateDTO);
            return ResponseEntity.ok(discom);
        } catch (Exception e) {
            logger.error("Error while updating Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete Discom

    // @PatchMapping("/{id}")
    // public ResponseEntity<String> setActive(@PathVariable int id) {
    // try {
    // discomService.deleteDiscom(id);
    // return ResponseEntity.ok("Discom deleted");
    // } catch (Exception e) {
    // logger.error("Error while deleting Discom", e);
    // return ResponseEntity.badRequest().build();
    // }
    // }

    // Get Discom by Active

    @GetMapping("/active")
    public ResponseEntity<List<DiscomResponse>> getDiscomByActive(@RequestParam boolean active) {
        try {
            List<DiscomResponse> discoms = discomService.getDiscomByActive(active);
            return ResponseEntity.ok(discoms);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/card/active")
    public ResponseEntity<List<DiscomCardDTO>> getDiscomCardByActive(@RequestParam boolean active) {
        try {
            List<DiscomCardDTO> discomscard = discomService.getDiscomCardByActive(active);
            return ResponseEntity.ok(discomscard);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tree/active")
    public ResponseEntity<List<DiscomTreeDTO>> getDiscomTreeByActive(@RequestParam boolean active) {
        try {
            List<DiscomTreeDTO> discomstree = discomService.getDiscomTreeByActive(active);
            return ResponseEntity.ok(discomstree);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Soft Delete Discom

    @PatchMapping("/delete/{id}")
    public ResponseEntity<String> updateDiscomStatus(@PathVariable int id) {
        try {
            discomService.deleteDiscom(id);
            return ResponseEntity.ok("Discom deleted");
        } catch (Exception e) {
            logger.error("Error while deleting Discom", e);
            return ResponseEntity.badRequest().build();
        }
    }
}