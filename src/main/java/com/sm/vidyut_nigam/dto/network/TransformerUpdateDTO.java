package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TransformerUpdateDTO {
    @NotBlank(message = "Transformer name cannot be blank")
    @Size(max = 100, message = "Transformer name must not exceed 100 characters")
    private String transformerName;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private float transformerLongitude;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private float transformerLatitude;

    private String transformerPicture;

    @Positive(message = "Transformer capacity must be a positive number")
    private int transformerCapacity;

    private LocalDateTime transformerUpdatedAt;

    @NotBlank(message = "Updated by field cannot be blank")
    @Size(max = 50, message = "Updated by field must not exceed 50 characters")
    private String transformerUpdatedBy;

    private LocalDateTime transformerApplicableFrom;
    private LocalDateTime transformerApplicableTo;
    private boolean transformerActive;
    private LocalDate transformerMaintenanceDate;

    @Positive(message = "Oil capacity must be a positive number")
    private float transformerOilCapacity;

    @Min(value = 1, message = "Feeder ID must be a positive number")
    private int feederCode;
}
