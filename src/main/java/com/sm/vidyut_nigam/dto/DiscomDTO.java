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
public class DiscomDTO {

    @NotNull(message = "Discom code is required")
    private int discomCode;

    @NotNull(message = "Discom name is required")
    @Size(min = 3, max = 100, message = "Discom name must be between 3 and 100 characters")
    private String discomName;

    @NotBlank(message = "Discom name is requied")
    @Size(max = 100, message = "Discom in-charge name must not exceed 100 characters")
    private String discomInChargeName;

    @NotBlank(message = "designation name is required")
    @Size(max = 50, message = "Designation name must not exceed 50")
    private String discomDesignation;

    @NotBlank(message = "Address is required")
    @Size(max = 300, message = "Address must not exceed 200 characters")
    private String discomAddress;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact phone must be 10-15 digits")
    private String discomContactPhone;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid email format")
    private String discomContactEmail;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float discomLongitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float discomLatitude;

    private String discomPicture;
    private String discomCreatedBy;
    private String discomUpdatedBy;
    private LocalDateTime discomCreatedAt;
    private LocalDateTime discomUpdatedAt;
    private LocalDateTime discomApplicableFrom;
    private LocalDateTime discomApplicableTo;
    @NotNull(message = "Active status is required")
    private boolean discomActive;
}
