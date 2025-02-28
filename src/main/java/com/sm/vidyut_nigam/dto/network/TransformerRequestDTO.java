package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransformerRequestDTO {

    private int transformerCode;

    @NotBlank(message = "Transformer name cannot be blank")
    @Size(max = 100, message = "Transformer name must not exceed 100 characters")
    private String transformerName;

    @NotNull(message = "Longitude is required")
    private Float transformerLongitude;

    @NotNull(message = "Latitude is required")
    private Float transformerLatitude;

    private String transformerPicture;

    @NotNull(message = "Transformer capacity cannot be null")
    @Positive(message = "Transformer capacity must be a positive number")
    private Integer transformerCapacity;

    @NotNull(message = "Created at timestamp cannot be null")
    private LocalDateTime transformerCreatedAt;

    @NotBlank(message = "Created by field cannot be blank")
    @Size(max = 50, message = "Created by field must not exceed 50 characters")
    private String transformerCreatedBy;

    @NotNull(message = "Applicable from date cannot be null")
    private LocalDateTime transformerApplicableFrom;

    private LocalDateTime transformerApplicableTo;

    @NotNull(message = "Active status is required")
    private Boolean transformerActive;

    @NotNull(message = "Manufacture date is required")
    private LocalDate transformerManufactureDate;

    @NotNull(message = "Installation date is required")
    private LocalDate transformerInstallationDate;

    private LocalDate transformerMaintenanceDate;

    @NotNull(message = "Oil capacity is required")
    @Positive(message = "Oil capacity must be a positive number")
    private Float transformerOilCapacity;

    @NotNull(message = "Feeder is required")
    private Integer feederCode;
}
