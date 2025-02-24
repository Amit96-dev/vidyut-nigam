package com.sm.vidyut_nigam.dto.ResponseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SubDivisionResponse {

    private int subDivisionCode;

    private String subDivisionName;

    private String subDivisionInChargeName;

    private String subDivisionDesignation;

    private String subDivisionAddress;

    private String subDivisionContactPhone;

    private String subDivisionContactEmail;

    private float subDivisionLongitude;

    private float subDivisionLatitude;

    private String subDivisionPicture;

    private LocalDateTime subDivisionCreatedAt;

    private String subDivisionCreatedBy;

    private LocalDateTime subDivisionUpdatedAt;

    private String subDivisionUpdatedBy;

    private LocalDateTime subDivisionApplicableFrom;

    private LocalDateTime subDivisionApplicableTo;

    private boolean subDivisionActive;

    private int divisionCode;
}
