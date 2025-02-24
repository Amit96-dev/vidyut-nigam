package com.sm.vidyut_nigam.dto.ResponseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class SectionResponse {

    private int sectionCode;

    private String sectionName;

    private String sectionInChargeName;

    private String sectionDesignation;

    private String sectionAddress;

    private String sectionContactPhone;

    private String sectionContactEmail;

    private float sectionLongitude;

    private float sectionLatitude;

    private String sectionPicture;

    private LocalDateTime sectionCreatedAt;

    private String sectionCreatedBy;

    private LocalDateTime sectionUpdatedAt;

    private String sectionUpdatedBy;

    private LocalDateTime sectionApplicableFrom;

    private LocalDateTime sectionApplicableTo;

    private boolean sectionActive;

    private int subDivisionCode;
}
