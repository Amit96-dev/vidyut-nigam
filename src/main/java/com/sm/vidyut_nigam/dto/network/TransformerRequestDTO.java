package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransformerRequestDTO {
    
    @NotNull(message = "Transformer code cannot be null")
    @Min(value = 1, message = "Transformer code must be a positive number")
    private int transformerCode;

    @NotBlank(message = "Transformer name cannot be blank")
    @Size(max = 100, message = "Transformer name must not exceed 100 characters")
    private String transformerName;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float transferLongitude;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float transferLatitude;

    private String transformerPicture;

    @NotNull(message = "Transformer capacity cannot be null")
    @Positive(message = "Transformer capacity must be a positive number")
    private int transformerCapacity;

    @NotBlank(message = "Created by field cannot be blank")
    @Size(max = 50, message = "Created by field must not exceed 50 characters")
    private String transformerCreatedBy;

    @NotNull(message = "Applicable from date cannot be null")
    private LocalDateTime transformerApplicableFrom;

    private LocalDateTime transformerApplicableTo;

    private boolean transformerActive;

    @NotNull(message = "Manufacture date is required")
    private LocalDate transformerManufactureDate;

    @NotNull(message = "Installation date is required")
    private LocalDate transformerInstallationDate;

    private LocalDate transformerMaintenanceDate;

    @NotNull(message = "Oil capacity is required")
    @Positive(message = "Oil capacity must be a positive number")
    private float transformerOilCapacity;

    @NotNull(message = "Feeder ID is required")
    @Min(value = 1, message = "Feeder ID must be a positive number")
    private int feeder;
}
