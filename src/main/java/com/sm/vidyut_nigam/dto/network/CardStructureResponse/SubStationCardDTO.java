package com.sm.vidyut_nigam.dto.network.CardStructureResponse;

import lombok.Data;

@Data
public class SubStationCardDTO {

    private int subStationCode;

    private String subStationName;

    private String subStationInChargeName;

    private String subStationDesignation;

    private String subStationAddress;
}
