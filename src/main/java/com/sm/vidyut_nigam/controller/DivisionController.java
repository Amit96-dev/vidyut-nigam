package com.sm.vidyut_nigam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.service.DivisionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/division")
public class DivisionController {

    private final DivisionService divisionService;

    // Create Division

    @PostMapping
    public ResponseEntity<DivisionDTO> createDivision(@Valid @RequestBody DivisionDTO divisionDTO) {
        try {
            DivisionDTO divisionDto2 = divisionService.createDivision(divisionDTO);
            return ResponseEntity.ok(divisionDto2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{divisionCode}")
    public ResponseEntity<DivisionDTO> getDivisionByCode(@PathVariable int divisionCode) {
        try {
            DivisionDTO divisionDto = divisionService.getDivisionByDivisionCode(divisionCode);
            return ResponseEntity.ok(divisionDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DivisionDTO>> getAllDivision() {
        try {
            List<DivisionDTO> divisionDtos = divisionService.getAllDivisions();
            return ResponseEntity.ok(divisionDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{divisionCode}")
    public ResponseEntity<DivisionDTO> updateDivision(@Valid @RequestBody DivisionDTO divisionDTO, @PathVariable int divisionCode) {
        try {
            DivisionDTO divisionDto2 = divisionService.updateDivision(null, divisionCode);
            return ResponseEntity.ok(divisionDto2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
