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

import com.sm.vidyut_nigam.dto.network.SubStationDTO;
import com.sm.vidyut_nigam.service.network.SubStationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sub-station")
public class SubStationController {

    private final SubStationService subStationService;

    @PostMapping
    public ResponseEntity<?> createSubStation(@Valid @RequestBody SubStationDTO subStationDTO) {
        try {
            SubStationDTO subStation = subStationService.createSubStation(subStationDTO);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllSubStation() {
        try {
            List<SubStationDTO> subStation = subStationService.getAllSubStations();
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/sub-station")
    public ResponseEntity<?> getSubStationById(@PathVariable int code) {
        try {
            SubStationDTO subStation = subStationService.getSingleSubStationByCode(code);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<?> updateSubStation(@Valid @RequestBody SubStationDTO subStationDTO, @PathVariable int code) {
        try {
            SubStationDTO subStation = subStationService.updateSubStation(subStationDTO, code);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/delete/{code}")
    public ResponseEntity<?> deleteSubStation(@PathVariable int code) {
        try {
            subStationService.deleteSubStation(code);
            return ResponseEntity.ok("SubStation deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<?> getSubStationByActive(@RequestParam boolean active) {
        try {
            List<SubStationDTO> subStation = subStationService.getSubStationByActive(active);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchSubStation(@PathVariable String keyword) {
        try {
            List<SubStationDTO> subStation = subStationService.searchBySubStationName(keyword);
            return ResponseEntity.ok(subStation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
