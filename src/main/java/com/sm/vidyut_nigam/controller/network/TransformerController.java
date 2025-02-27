package com.sm.vidyut_nigam.controller.network;

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

import com.sm.vidyut_nigam.dto.network.TransformerRequestDTO;
import com.sm.vidyut_nigam.service.network.TransformerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transformer")
public class TransformerController {

    private final TransformerService transformerService;

    // Create Transformer
    @PostMapping
    public ResponseEntity<?> createTransformer(@Valid @RequestBody TransformerRequestDTO transformerRequestDTO) {
        try {
            transformerService.createTransformer(transformerRequestDTO);
            return ResponseEntity.ok("Transformer created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating transformer");
        }
    }

    // Get All Transformer
    @GetMapping
    public ResponseEntity<?> getAllTransformer() {
        try {
            return ResponseEntity.ok(transformerService.getAllTransformers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching transformers");
        }
    }

    // Get single Transformer
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleTransformer(@PathVariable int transformerCode) {
        try {
            return ResponseEntity.ok(transformerService.getSingleTransformerByCode(transformerCode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching transformer");
        }
    }

    // Update Transformer
    @PutMapping("/update/{transformerCode}")
    public ResponseEntity<?> updateTransformer(@Valid @RequestBody TransformerRequestDTO transformerRequestDTO,
            @PathVariable int transformerCode) {
        try {
            transformerService.updateTransformer(transformerRequestDTO);
            return ResponseEntity.ok("Transformer updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating transformer");
        }
    }

    // Get All Active Transformer
    @GetMapping("/active")
    public ResponseEntity<?> getTransformerByActive(@RequestParam boolean active) {
        try {
            return ResponseEntity.ok(transformerService.getAllTransformerByActive(active));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching transformer");
        }
    }

    // Delete Transformer
    @PatchMapping("/delete/{transformerCode}")
    public ResponseEntity<?> deleteTransformer(@PathVariable int transformerCode) {
        try {
            transformerService.deleteTransformer(transformerCode);
            return ResponseEntity.ok("Transformer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting transformer");
        }
    }

    // Get all Transformer by feederCode
    @GetMapping("/feeder-code/{feederCode}")
    public ResponseEntity<?> getAllTransformerByFeederCode(@PathVariable int feederCode) {
        try {
            return ResponseEntity.ok(transformerService.getAllTransformerByFeederCode(feederCode));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching transformer");
        }
    }
}
