package com.sm.vidyut_nigam.dto.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SubStationResponseDTO {
    private int subStationCode;

    private String subStationName;

    private String subStationInChargeName;

    private String subStationDesignation;

    private String subStationAddress;

    private Double subStationLongitude;

    private Double subStationLatitude;

    private String subStationPicture;

    private int subStationCapacity;

    private LocalDateTime subStationCreatedAt;

    private String subStationCreatedBy;

    private String subStationUpdatedBy;

    private LocalDateTime subStationUpdatedDt;

    private LocalDate subStationApplicableFrom;

    private LocalDate subStationApplicableTo;

    private boolean subStationActive;
}
