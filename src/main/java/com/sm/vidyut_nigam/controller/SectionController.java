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

import com.sm.vidyut_nigam.dto.SectionDTO;
import com.sm.vidyut_nigam.dto.SectionUpdateDTO;
import com.sm.vidyut_nigam.dto.CardStuructureResponse.SectionCardDTO;
import com.sm.vidyut_nigam.dto.ResponseDTO.SectionResponse;
import com.sm.vidyut_nigam.dto.TreeStructureResponse.SectionTreeDTO;
import com.sm.vidyut_nigam.service.SectionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<?> createSection(@Valid @RequestBody SectionDTO sectionDTO) {
        try {
            String section = sectionService.createSection(sectionDTO);
            return ResponseEntity.ok(section);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllSection() {
        try {
            List<SectionResponse> sections = sectionService.getAllSection();
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getSingleSection/{sectionCode}")
    public ResponseEntity<?> getSectionByCode(@PathVariable int sectionCode) {
        try {
            SectionResponse section = sectionService.getSectionBySectionCode(sectionCode);
            return ResponseEntity.ok(section);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + sectionCode);
        }
    }

    @PutMapping("/update/{sectionCode}")
    public ResponseEntity<?> updateSection(@Valid @RequestBody SectionUpdateDTO sectionUpdateDTO,
            @PathVariable int sectionCode) {
        System.out.println(sectionCode);
        try {
            String section = sectionService.updateSection(sectionUpdateDTO, sectionCode);
            return ResponseEntity.ok(section);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/deactivate/{sectionCode}")
    public ResponseEntity<String> deleteSection(@PathVariable int sectionCode) {
        try {
            sectionService.deactivateSection(sectionCode);
            return ResponseEntity.ok("Section deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + sectionCode);
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<SectionResponse>> getSectionByActive(@RequestParam boolean active) {
        try {
            List<SectionResponse> sections = sectionService.getSectionByActive(active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/active/{subDivisionCode}")
    public ResponseEntity<List<?>> getActiveSectionBySubDivisionCode(@PathVariable int subDivisionCode,
            @RequestParam boolean active) {
        try {
            List<SectionResponse> sections = sectionService.getActiveSectionBySubDivisionCode(subDivisionCode, active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/card/active/{subDivisionCode}")
    public ResponseEntity<List<?>> getActiveSectionCardBySubDivisionCode(@PathVariable int subDivisionCode,
            @RequestParam boolean active) {
        try {
            List<SectionCardDTO> sections = sectionService.getActiveSectionCardBySubDivisionCode(subDivisionCode,
                    active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tree/active/{subDivisionCode}")
    public ResponseEntity<List<?>> getActiveSectionTreeBySubDivisionCode(@PathVariable int subDivisionCode,
            @RequestParam boolean active) {
        try {
            List<SectionTreeDTO> sections = sectionService.getActiveSectionTreeBySubDivisionCode(subDivisionCode,
                    active);
            return ResponseEntity.ok(sections);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
