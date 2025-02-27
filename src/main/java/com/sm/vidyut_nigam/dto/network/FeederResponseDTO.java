package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FeederResponseDTO {
    private int feederCode;

    private String feederName;

    private String feederAddress;

    private Float feederLongitude;

    private Float feederLatitude;

    private String feederPicture;

    private int feederCapacity;

    private LocalDateTime feederCreatedAt;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime feederUpdatedAt;

    private LocalDate feederApplicableFrom;

    private LocalDate feederApplicableTo;

    private boolean feederActive;

    private int subStationCode;
}
