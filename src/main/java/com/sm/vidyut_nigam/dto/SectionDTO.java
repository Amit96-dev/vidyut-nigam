package com.sm.vidyut_nigam.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SectionDTO {
    private int sectionCode;

    @NotNull(message = "Section name is required")
    @Size(min = 3, max = 100, message = "Discom name must be between 3 and 100 characters")
    private String sectionName;

    private String sectionInChargeName;

    private String sectionDesignation;

    private String sectionAddress;

    private String sectionContactPhone;

    private String sectionContactEmail;
    private float sectionLongitude;
    private float sectionLatitude;
    private String sectionPicture;

    private LocalDateTime SectionCreatedAt;

    private String sectionCreatedBy;
    private LocalDateTime sectionUpdatedAt;
    private String sectionUpdatedBy;
    private LocalDateTime sectionApplicableFrom;
    private LocalDateTime sectionApplicableTo;
    
    private boolean active;
}
