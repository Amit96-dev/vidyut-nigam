package com.sm.vidyut_nigam.dto.ResponseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class DivisionResponse {
    private int divisionCode;

    private String divisionName;

    private String divisionInChargeName;

    private String divisionDesignation;

    private String divisionAddress;

    private String divisionContactPhone;

    private String divisionContactEmail;

    private float divisionLongitude;

    private float divisionLatitude;

    private String divisionPicture;

    private int circleCode;

    private LocalDateTime divisionCreatedAt;

    private String divisionCreatedBy;

    private LocalDateTime divisionUpdatedAt;

    private String divisionUpdatedBy;

    private LocalDateTime divisionApplicableFrom;

    private LocalDateTime divisionApplicableTo;

    private boolean divisionActive;
}
