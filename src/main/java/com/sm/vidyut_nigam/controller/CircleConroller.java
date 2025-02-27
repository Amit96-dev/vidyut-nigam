package com.sm.vidyut_nigam.controller;

// import java.time.LocalDateTime;
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

import com.sm.vidyut_nigam.dto.CircleDTO;
import com.sm.vidyut_nigam.dto.CircleUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.CircleCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.CircleResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.CircleTreeDTO;
import com.sm.vidyut_nigam.service.CircleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/api/circle")
@RequiredArgsConstructor
public class CircleConroller {

    private final CircleService circleService;

    Logger logger = LoggerFactory.getLogger(CircleConroller.class);

    // Create circle
    @PostMapping
    public ResponseEntity<?> createCircle(@Valid @RequestBody CircleDTO circleDTO) {
        try {
            String circle = circleService.createCircle(circleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(circle);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get all circle by discomCode
    @GetMapping("allCircle/{discomCode}")
    public ResponseEntity<List<CircleResponse>> getAllCircleByDiscomCode(@PathVariable int discomCode) {
        try {
            List<CircleResponse> circles = circleService.getAllCirclesByDiscomCode(discomCode);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            logger.error("Error while getting all Circle", e);
            return ResponseEntity.badRequest().build();
        }
    }

    // Get circle by circle code and discom code
    @GetMapping("getSingle/{circleCode}")
    public ResponseEntity<?> getCircleByCircleCode(@PathVariable int circleCode) {
        try {
            CircleResponse circleById = circleService.getCircleByCode(circleCode);
            return ResponseEntity.ok(circleById);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + circleCode);
        }
    }

    // update circle

    @PutMapping("/{circleCode}")
    public ResponseEntity<?> updateCircle(@Valid @RequestBody CircleUpdateDTO circleUpdateDTO,
            @PathVariable int circleCode) {
        try {
            String circle = circleService.updateCircle(circleCode,
                    circleUpdateDTO);
            return ResponseEntity.ok(circle);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get Circle by Active

    @GetMapping("/active")
    public ResponseEntity<List<CircleResponse>> getCircleByActive(@RequestParam boolean active) {
        try {
            List<CircleResponse> circles = circleService.getCircleByActive(active);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all active circle by discom code
    @GetMapping("/active/{discomCode}")
    public ResponseEntity<List<CircleResponse>> getCircleByDiscomCode(@PathVariable int discomCode,
            @RequestParam boolean active) {
        try {
            List<CircleResponse> circles = circleService.getActiveCircleByDiscomCode(discomCode, active);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/card/active/{discomCode}")
    public ResponseEntity<List<CircleCardDTO>> getCircleCardByDiscomCode(@PathVariable int discomCode,
            @RequestParam boolean active) {
        try {
            List<CircleCardDTO> circles = circleService.getActiveCircleCardByDiscomCode(discomCode, active);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            logger.error("Error while getting Discom by active", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tree/active/{discomCode}")
    public ResponseEntity<List<CircleTreeDTO>> getCircleTreeByDiscomCode(@PathVariable int discomCode,
            @RequestParam boolean active) {
        try {
            List<CircleTreeDTO> circles = circleService.getActiveCircleTreeByDiscomCode(discomCode, active);
            return ResponseEntity.ok(circles);
        } catch (Exception e) {
            logger.error("Error while getting Circle by active", e);
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
