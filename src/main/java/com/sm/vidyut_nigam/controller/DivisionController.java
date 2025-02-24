package com.sm.vidyut_nigam.controller;

import java.util.List;

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

import com.sm.vidyut_nigam.dto.DivisionDTO;
import com.sm.vidyut_nigam.dto.DivisionUpdateDTO;
import com.sm.vidyut_nigam.service.DivisionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/division")
public class DivisionController {

    private final DivisionService divisionService;

    // Create Division

    @PostMapping
    public ResponseEntity<?> createDivision(@Valid @RequestBody DivisionDTO divisionDTO) {
        try {
            DivisionDTO divisionDto2 = divisionService.createDivision(divisionDTO);
            return ResponseEntity.ok(divisionDto2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Get Division by Division Code

    @GetMapping("singleDivision/{divisionCode}")
    public ResponseEntity<?> getDivisionByCode(@PathVariable int divisionCode) {
        try {
            DivisionDTO divisionDto = divisionService.getDivisionByDivisionCode(divisionCode);
            return ResponseEntity.ok(divisionDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // @GetMapping
    // public ResponseEntity<List<DivisionDTO>> getAllDivision() {
    // try {
    // List<DivisionDTO> divisionDtos = divisionService.getAllDivisions();
    // return ResponseEntity.ok(divisionDtos);
    // } catch (Exception e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }
    // }

    // Get all active division
    @GetMapping("/active")
    public ResponseEntity<List<DivisionDTO>> getCircleByActive(@RequestParam boolean active) {
        try {
            List<DivisionDTO> division = divisionService.findDivisionByActive(active);
            return ResponseEntity.ok(division);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all active division by circle code

    @GetMapping("/active/{circleCode}")
    public ResponseEntity<List<DivisionDTO>> getDivisionByCircleCode(@PathVariable int circleCode,
            @RequestParam boolean active) {
        try {
            List<DivisionDTO> divisions = divisionService.findActiveDivisionByCircleCode(circleCode, active);
            return ResponseEntity.ok(divisions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Update Division

    @PutMapping("updateDivision/{divisionCode}")
    public ResponseEntity<DivisionDTO> updateDivision(@Valid @RequestBody DivisionUpdateDTO divisionUpdateDTO,
            @PathVariable int divisionCode) {
        try {
            DivisionDTO divisionDto2 = divisionService.updateDivision(divisionUpdateDTO,
                    divisionCode);
            return ResponseEntity.ok(divisionDto2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete Division

    @PatchMapping("deleteDivision/{code}")
    public ResponseEntity<String> deleteDivision(@PathVariable int code) {
        try {
            String result = divisionService.deleteDivision(code);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + code);
        }
    }
}
