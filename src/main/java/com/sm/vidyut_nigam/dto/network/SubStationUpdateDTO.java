package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubStationUpdateDTO {
    private int subStationCode;

    @NotBlank(message = "Substation name cannot be empty")
    @Size(max = 100, message = "Substation name must not exceed 100 characters")
    private String subStationName;

    @Size(max = 100, message = "In-Charge name must not exceed 100 characters")
    private String subStationInChargeName;

    @Size(max = 50, message = "Designation must not exceed 50 characters")
    private String subStationDesignation;

    @NotBlank(message = "Address cannot be empty")
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String subStationAddress;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private Double subStationLongitude;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double subStationLatitude;

    @Size(max = 255, message = "Picture URL must not exceed 255 characters")
    private String subStationPicture;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 1, message = "Capacity must be at least 1 MW or MVA")
    private int subStationCapacity;

    @Size(max = 100, message = "Updated by must not exceed 100 characters")
    private String subStationUpdatedBy;

    // @PastOrPresent(message = "Updated date must be in the past or present")
    private LocalDateTime subStationUpdatedDt;

    // @FutureOrPresent(message = "Applicable from date must be today or in the future")
    private LocalDate subStationApplicableFrom;

    // @Future(message = "Applicable to date must be in the future")
    private LocalDate subStationApplicableTo;

    @NotNull(message = "Active status must be specified")
    private boolean subStationActive;
}
