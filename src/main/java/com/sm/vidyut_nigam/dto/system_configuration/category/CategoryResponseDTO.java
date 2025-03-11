package com.sm.vidyut_nigam.dto.system_configuration.category;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CategoryResponseDTO {

    private String categoryName;
    private double categoryEmergencyCredit;
    private boolean categoryStatus;
    private LocalDateTime categoryCreatedAt;
    private LocalDateTime categoryUpdatedAt;
}
