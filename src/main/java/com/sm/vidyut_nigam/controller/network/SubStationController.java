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

import com.sm.vidyut_nigam.dto.network.SubStationRequestDTO;
import com.sm.vidyut_nigam.dto.network.SubStationResponseDTO;
import com.sm.vidyut_nigam.dto.network.SubStationUpdateDTO;
import com.sm.vidyut_nigam.dto.network.CardStructureResponse.SubStationCardDTO;
import com.sm.vidyut_nigam.service.network.SubStationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sub-station")
public class SubStationController {

    private final SubStationService subStationService;

    @PostMapping
    public ResponseEntity<?> createSubStation(@Valid @RequestBody SubStationRequestDTO subStationDTO) {
        try {
            SubStationRequestDTO subStation = subStationService.createSubStation(subStationDTO);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllSubStation() {
        try {
            List<SubStationResponseDTO> subStation = subStationService.getAllSubStations();
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<?> getSubStationById(@PathVariable int code) {
        try {
            SubStationRequestDTO subStation = subStationService.getSingleSubStationByCode(code);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Update
    @PutMapping("/update/{code}")
    public ResponseEntity<?> updateSubStation(@Valid @RequestBody SubStationUpdateDTO subStationUpdateDTO,
            @PathVariable int code) {
        try {
            SubStationUpdateDTO subStation = subStationService.updateSubStation(subStationUpdateDTO, code);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Delete sub-station
    @PatchMapping("/delete/{code}")
    public ResponseEntity<?> deleteSubStation(@PathVariable int code) {
        try {
            subStationService.deleteSubStation(code);
            return ResponseEntity.ok("SubStation deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all active
    @GetMapping("/active")
    public ResponseEntity<?> getSubStationByActive(@RequestParam boolean active) {
        try {
            List<SubStationRequestDTO> subStation = subStationService.getSubStationByActive(active);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all active in card format
    @GetMapping("/card/active")
    public ResponseEntity<?> getSubStationCardByActive(@RequestParam boolean active) {
        try {
            List<SubStationCardDTO> subStation = subStationService.getSubStationCardByActive(active);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Search Sub-Station by name
    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchSubStation(@PathVariable String keyword) {
        try {
            List<SubStationRequestDTO> subStation = subStationService.searchBySubStationName(keyword);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
