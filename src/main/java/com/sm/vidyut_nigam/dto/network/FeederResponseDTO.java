package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FeederResponseDTO {
    private int feederCode;

    @NotBlank(message = "Feeder name cannot be empty")
    @Size(max = 100, message = "Feeder name must not exceed 100 characters")
    private String feederName;

    @NotBlank(message = "Feeder address cannot be empty")
    @Size(max = 255, message = "Feeder address must not exceed 255 characters")
    private String feederAddress;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private Float feederLongitude;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Float feederLatitude;

    @Size(max = 255, message = "Picture URL must not exceed 255 characters")
    private String feederPicture;

    @NotNull(message = "Feeder capacity cannot be null")
    @Min(value = 1, message = "Feeder capacity must be at least 1 MW or MVA")
    private int feederCapacity;

    private LocalDateTime feederCreatedAt;

    @NotBlank(message = "Created by cannot be empty")
    @Size(max = 100, message = "Created by must not exceed 100 characters")
    private String createdBy;

    @Size(max = 100, message = "Updated by must not exceed 100 characters")
    private String updatedBy;

    private LocalDateTime feederUpdatedAt;

    @FutureOrPresent(message = "Applicable from date must be today or in the future")
    private LocalDate feederApplicableFrom;

    @Future(message = "Applicable to date must be in the future")
    private LocalDate feederApplicableTo;

    @NotNull(message = "Feeder active status must be specified")
    private boolean feederActive;

    @NotNull(message = "Substation code cannot be null")
    private int subStationCode;  // Instead of SubStation entity, use its ID
}
