package com.sm.vidyut_nigam.controller;

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

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
import com.sm.vidyut_nigam.service.SectionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<SectionDTO> createSection(@Valid @RequestBody SectionDTO sectionDTO) {
        try {
            SectionDTO section = sectionService.createSection(sectionDTO);
            return ResponseEntity.ok(section);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SectionDTO>> getAllSection() {
        try {
            List<SectionDTO> sections = sectionService.getAllSection();
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("update/{sectionCode}")
    public ResponseEntity<SectionDTO> updateSection(@Valid @RequestBody SectionUpdateDTO sectionUpdateDTO,
            int sectionCode) {
        try {
            SectionDTO section = sectionService.updateSection(sectionUpdateDTO, sectionCode);
            return ResponseEntity.ok(section);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/deactivate/{sectionCode}")
    public ResponseEntity<String> deleteSection(@PathVariable int sectionCode) {
        try {
            sectionService.deactivateSection(sectionCode);
            return ResponseEntity.ok("Section deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<SectionDTO>> getSectionByActive(@RequestParam boolean active) {
        try {
            List<SectionDTO> sections = sectionService.getSectionByActive(active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{subDivisionCode}/active")
    public ResponseEntity<List<SectionDTO>> getActiveSectionBySubDivisionCode(@PathVariable int subDivivisionCode,
            @RequestParam boolean active) {
        try {
            List<SectionDTO> sections = sectionService.getActiveSectionBySubDivisionCode(subDivivisionCode, active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
