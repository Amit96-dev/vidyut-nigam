package com.sm.vidyut_nigam.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DivisionUpdateDTO {

    @NotNull(message = "Division code is required")
    private int divisionCode;

    @NotNull(message = "Division name is required")
    @Size(min = 3, max = 100, message = "Division name must be between 3 to 100 characters")
    private String divisionName;

    @NotBlank(message = "Division in-charge name is required")
    @Size(max = 100, message = "Division in-charge name must not exceed 100 characters")
    private String divisionInChargeName;

    @NotBlank(message = "Division designation is required")
    @Size(max = 50, message = "Division designation must not exceed 50 characters")
    private String divisionDesignation;

    @NotBlank(message = "Division address is required")
    @Size(max = 300, message = "Division address must not exceed 300 characters")
    private String divisionAddress;

    @NotBlank(message = "Division contact phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Division contact phone must be 10-15 digits")
    private String divisionContactPhone;

    @NotBlank(message = "Division contact email is required")
    @Email(message = "Invalid email format")
    private String divisionContactEmail;

    @NotNull(message = "Division longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float divisionLongitude;

    @NotNull(message = "Division latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float divisionLatitude;

    private String divisionPicture;

    @NotNull(message = "Circle code is required")
    private int circleCode;

    private LocalDateTime divisionUpdatedAt;
    private String divisionUpdatedBy;
    private LocalDateTime divisionApplicableFrom;
    private LocalDateTime divisionApplicableTo;

    @NotNull(message = "Active status is required")
    private boolean divisionActive;
}
