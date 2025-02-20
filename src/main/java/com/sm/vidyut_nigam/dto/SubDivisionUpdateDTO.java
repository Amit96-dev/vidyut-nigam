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
public class SubDivisionUpdateDTO {
    @NotNull(message = "SubDivision-code is required")
    private String subDivisionName;

    @NotNull(message = "SubDivision-name is required")
    @Size(min = 3, max = 100, message = "Sub-division name must be between 3 and 100 characters")
    private String subDivisionInChargeName;

    @NotBlank(message = "Sub-division in-charge name is requied")
    @Size(min =3,max = 100, message = "Sub-division in-charge name must not exceed 100 characters")
    private String subDivisionDesignation;

    @NotBlank(message = "Address is required")
    @Size(max = 300, message = "Address must not exceed 200 characters")
    private String subDivisionAddress;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact phone must be 10-15 digits")
    private String subDivisionContactPhone;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid email format")
    private String subDivisionContactEmail;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float subDivisionLongitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float subDivisionLatitude;

    private String subDivisionPicture;

    private String subDivisionUpdatedBy;
    private LocalDateTime subDivisionUpdatedAt;
    private LocalDateTime subDivisionApplicableFrom;
    private LocalDateTime subDivisionApplicableTo;

    @NotNull(message = "Active status is required")
    private boolean active;

    private int subDivisionParentCode;
}
