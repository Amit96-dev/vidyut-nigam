package com.sm.vidyut_nigam.dto.network.CardStructureResponse;

import lombok.Data;

@Data

public class TransformerCardDTO {
    private int transformerCode;

    private String transformerName;

    private float transformerLongitude;

    private float transformerLatitude;

    private int transformerCapacity;

    private float transformerOilCapacity;
}
