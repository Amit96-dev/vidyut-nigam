package com.sm.vidyut_nigam.controller;

// import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.service.CircleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/circle")
@RequiredArgsConstructor
public class CircleConroller {
    
    private final CircleService circleService;

    Logger logger = LoggerFactory.getLogger(CircleConroller.class);

    @PostMapping
    public ResponseEntity<CircleDTO> createDiscom(@Valid @RequestBody CircleDTO circleDTO) {
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
}
