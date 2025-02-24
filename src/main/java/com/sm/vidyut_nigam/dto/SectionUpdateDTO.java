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
public class SectionUpdateDTO {
    private int sectionCode;

    @NotNull(message = "Section name is required")
    @Size(min = 3, max = 100, message = "Section name must be between 3 and 100 characters")
    private String sectionName;

    @NotBlank(message = "Section Incharge-name is requied")
    @Size(max = 100, message = "Section in-charge name must not exceed 100 characters")
    private String sectionInChargeName;

    @NotBlank(message = "Designation name is required")
    @Size(max = 50, message = "Designation name must not exceed 50")
    private String sectionDesignation;

    @NotBlank(message = "Address is required")
    @Size(max = 300, message = "Address must not exceed 200 characters")
    private String sectionAddress;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact phone must be 10-15 digits")
    private String sectionContactPhone;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid email format")
    private String sectionContactEmail;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float sectionLongitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float sectionLatitude;

    private String sectionPicture;

    private LocalDateTime sectionUpdatedAt;
    private String sectionUpdatedBy;
    private LocalDateTime sectionApplicableFrom;
    private LocalDateTime sectionApplicableTo;

    @NotNull(message = "Active status is required")
    private boolean sectionActive;

    private int subDivisionCode;
}
