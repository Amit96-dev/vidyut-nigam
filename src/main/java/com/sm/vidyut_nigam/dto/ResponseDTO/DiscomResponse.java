package com.sm.vidyut_nigam.dto.ResponseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DiscomResponse {

    private int discomCode;

    private String discomName;

    private String discomInChargeName;

    private String discomDesignation;

    private String discomAddress;

    private String discomContactPhone;

    private String discomContactEmail;

    private float discomLongitude;

    private float discomLatitude;

    private String discomPicture;

    private String discomCreatedBy;

    private String discomUpdatedBy;

    private LocalDateTime discomCreatedAt;

    private LocalDateTime discomUpdatedAt;

    private LocalDateTime discomApplicableFrom;

    private LocalDateTime discomApplicableTo;

    private boolean discomActive;
}
