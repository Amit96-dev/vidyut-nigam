package com.sm.vidyut_nigam.dto.ResponseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class CircleResponse {

    private int circleCode;

    private String circleName;

    private String circleInChargeName;

    private String circleDesignation;

    private String circleAddress;

    private String circleContactPhone;

    private String circleContactEmail;

    private float circleLongitude;

    private float circleLatitude;

    private String circlePicture;

    private int discomCode;

    private String circleCreatedBy;

    private String circleUpdatedBy;

    private LocalDateTime circleCreatedAt;

    private LocalDateTime circleUpdatedAt;

    private LocalDateTime circleApplicableFrom;

    private LocalDateTime circleApplicableTo;

    private boolean circleActive;
}
