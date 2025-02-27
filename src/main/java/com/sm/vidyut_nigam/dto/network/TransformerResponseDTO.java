package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransformerResponseDTO {
    
    @Min(value = 1, message = "Transformer code must be a positive number")
    private int transformerCode;

    @NotBlank(message = "Transformer name cannot be blank")
    @Size(max = 100, message = "Transformer name must not exceed 100 characters")
    private String transformerName;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float transferLongitude;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float transferLatitude;

    private String transformerPicture;

    @Positive(message = "Transformer capacity must be a positive number")
    private int transformerCapacity;

    private LocalDateTime transformerCreatedAt;

    @Size(max = 50, message = "Created by field must not exceed 50 characters")
    private String transformerCreatedBy;

    private LocalDateTime transformerUpdatedAt;

    @Size(max = 50, message = "Updated by field must not exceed 50 characters")
    private String transformerUpdatedBy;

    private LocalDateTime transformerApplicableFrom;
    private LocalDateTime transformerApplicableTo;

    private boolean transformerActive;

    private LocalDate transformerManufactureDate;
    private LocalDate transformerInstallationDate;
    private LocalDate transformerMaintenanceDate;

    @Positive(message = "Oil capacity must be a positive number")
    private float transformerOilCapacity;

    @Min(value = 1, message = "Feeder ID must be a positive number")
    private int feeder;
}
