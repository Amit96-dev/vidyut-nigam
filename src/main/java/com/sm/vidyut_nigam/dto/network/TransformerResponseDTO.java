package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TransformerResponseDTO {

    private int transformerCode;

    private String transformerName;

    private float transformerLongitude;

    private float transformerLatitude;

    private String transformerPicture;

    private int transformerCapacity;

    private LocalDateTime transformerCreatedAt;

    private String transformerCreatedBy;

    private LocalDateTime transformerUpdatedAt;

    private String transformerUpdatedBy;

    private LocalDateTime transformerApplicableFrom;

    private LocalDateTime transformerApplicableTo;

    private boolean transformerActive;

    private LocalDate transformerManufactureDate;

    private LocalDate transformerInstallationDate;

    private LocalDate transformerMaintenanceDate;

    private float transformerOilCapacity;

    private int feederCode;
}
