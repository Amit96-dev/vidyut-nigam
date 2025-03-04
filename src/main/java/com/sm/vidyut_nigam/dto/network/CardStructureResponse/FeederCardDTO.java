package com.sm.vidyut_nigam.dto.network.CardStructureResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FeederCardDTO {

    private int feederCode;

    @NotBlank(message = "Feeder name cannot be empty")
    @Size(max = 100, message = "Feeder name must not exceed 100 characters")
    private String feederName;

    @NotBlank(message = "Feeder address cannot be empty")
    @Size(max = 255, message = "Feeder address must not exceed 255 characters")
    private String feederAddress;

    private int feederCapacity;

}
