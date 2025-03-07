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
public class CircleUpdateDTO {
    private int circleCode;

    @NotNull(message = "Circle name is required.")
    @Size(min = 3, max = 100, message = "Circle name must be between 3 and 100 characters")
    private String circleName;

    @NotBlank(message = "Circle name is requied")
    @Size(max = 100, message = "Circle in-charge name must not exceed 100 characters")
    private String circleInChargeName;

    @NotBlank(message = "Designation is required")
    @Size(max = 50, message = "Designation must not exceed 50")
    private String circleDesignation;

    @NotBlank(message = "Address is required")
    @Size(max = 300, message = "Address must not exceed 200 characters")
    private String circleAddress;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact phone must be 10-15 digits")
    private String circleContactPhone;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid email format")
    private String circleContactEmail;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float circleLongitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float circleLatitude;

    private String circlePicture;

    @NotNull(message = "Discom ID is required")
    private int discomCode;

    private String circleUpdatedBy;
    private LocalDateTime circleUpdatedAt;
    private LocalDateTime circleApplicableFrom;
    private LocalDateTime circleApplicableTo;
    @NotNull(message = "Active status is required")
    private boolean circleActive;
}
