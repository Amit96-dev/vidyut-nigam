package com.sm.vidyut_nigam.controller;

// import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;
import com.sm.vidyut_nigam.service.CircleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/circle")
@RequiredArgsConstructor
public class CircleConroller {

    private final CircleService circleService;

    Logger logger = LoggerFactory.getLogger(CircleConroller.class);

    // Create circle
    @PostMapping
    public ResponseEntity<CircleDTO> createCircle(@Valid @RequestBody CircleDTO circleDTO) {
        try {
            // LocalDateTime currentTime = LocalDateTime.now();
            // circleDTO.setCreatedAt(currentTime);
            logger.info("********Controller************* {}", circleDTO);
            CircleDTO circle = circleService.createCircle(circleDTO);
            return ResponseEntity.ok(circle);
        } catch (Exception e) {
            logger.error("Error while creating Circle", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all circle
    @GetMapping
    public ResponseEntity<List<CircleDTO>> getAllCircle() {
        try {
            List<CircleDTO> circle = circleService.getAllCircles();
            return ResponseEntity.ok(circle);
        } catch (Exception e) {
            logger.error("Error while getting all Circle", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Get circle by circle code
    @GetMapping("getSingle/{circleCode}")
    public ResponseEntity<CircleDTO> getCircleByCircleCode(@PathVariable int circleCode) {
        CircleDTO circleById = circleService.getCircleByCode(circleCode);
        return ResponseEntity.ok(circleById);
    }

    // update circle

    @PutMapping("/{circleCode}")
    public ResponseEntity<CircleDTO> updateCircle(@Valid @RequestBody CircleUpdateDTO circleUpdateDTO,
            @PathVariable int circleCode) {
        try {
            CircleDTO circle = circleService.updateCircle(circleCode, circleUpdateDTO);
            return ResponseEntity.ok(circle);
        } catch (Exception e) {
            logger.error("Error while updating circle", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Get Circle by Active

    @GetMapping("/active")
    public ResponseEntity<List<CircleDTO>> getCircleByActive(@RequestParam boolean active) {
        try {
            List<CircleDTO> circles = circleService.getCircleByActive(active);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Delete Circle (Soft delete)

    @PatchMapping("/{circleCode}")
    public ResponseEntity<String> deleteCircle(@PathVariable int circleCode) {
        try {
            circleService.deleteCircle(circleCode);
            return ResponseEntity.ok("circle deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
