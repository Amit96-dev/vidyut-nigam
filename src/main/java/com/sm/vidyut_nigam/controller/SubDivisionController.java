package com.sm.vidyut_nigam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.sm.vidyut_nigam.dto.SubDivisionDTO;
import com.sm.vidyut_nigam.dto.SubDivisionUpdateDTO;
import com.sm.vidyut_nigam.service.SubDivisionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subdivision")
public class SubDivisionController {

    private final SubDivisionService subdivisionService;

    // Create SubDivision
    @PostMapping
    public ResponseEntity<?> createSubDivision(@Valid @RequestBody SubDivisionDTO subdivisionDTO) {
        try {
            SubDivisionDTO subDivision = subdivisionService.createSubDivision(subdivisionDTO);
            return ResponseEntity.ok(subDivision);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Get All SubDivisions
    @GetMapping
    public ResponseEntity<List<SubDivisionDTO>> getAllSubDivisions() {
        try {
            List<SubDivisionDTO> subDivisions = subdivisionService.getAllSubDivisions();
            return ResponseEntity.ok(subDivisions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update SubDivision
    @PutMapping("/{id}")
    public ResponseEntity<SubDivisionDTO> updateSubDivision(
            @Valid @RequestBody SubDivisionUpdateDTO subDivisionUpdateDTO, @PathVariable int id) {
        try {
            SubDivisionDTO subDivision = subdivisionService.updateSubDivision(subDivisionUpdateDTO, id);
            return ResponseEntity.ok(subDivision);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Deactivate Sub-division
    @PatchMapping("/{subDivisionCode}")
    public ResponseEntity<String> deActivateSubDivision(@PathVariable int subDivisionCode) {
        try {
            subdivisionService.deactivateSubDivision(subDivisionCode);
            return ResponseEntity.ok("SubDivision Deactivated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get Sub-division by sub-division code
    @GetMapping("/getSingleSubDivision/{subDivisionCode}")
    public ResponseEntity<?> getSubDivisionByCode(@PathVariable int subDivisionCode) {
        try {
            SubDivisionDTO subDivision = subdivisionService.getSubDivisionBySubDivisionCode(subDivisionCode);
            return ResponseEntity.ok(subDivision);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + subDivisionCode);
        }
    }

    // Get Sub-division by active
    @GetMapping("/active")
    public ResponseEntity<List<SubDivisionDTO>> getSubDivisionByActive(@RequestParam boolean active) {
        try {
            List<SubDivisionDTO> subDivisions = subdivisionService.getSubDivisionByActive(active);
            return ResponseEntity.ok(subDivisions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get SubDivision by Division code
    @GetMapping("/{divisionCode}/active")
    public ResponseEntity<List<SubDivisionDTO>> getActiveSubDivisionByDivisionCode(@PathVariable int divisionCode,
            @RequestParam boolean active) {
        try {
            List<SubDivisionDTO> subDivisions = subdivisionService.getActiveSubDivisionByDivisionCode(divisionCode,
                    active);
            return ResponseEntity.ok(subDivisions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
