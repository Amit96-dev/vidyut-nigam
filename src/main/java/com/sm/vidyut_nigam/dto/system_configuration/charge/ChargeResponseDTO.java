package com.sm.vidyut_nigam.dto.system_configuration.charge;

import java.time.LocalDateTime;

import com.sm.vidyut_nigam.constant.ChargeType;

import lombok.Data;

@Data
public class ChargeResponseDTO {
    private String chargeCode;
    private String chargeName;
    private boolean chargeStatus;
    private LocalDateTime chargeCreatedAt;
    private LocalDateTime chargeUpdatedAt;
    public ChargeType chargeType;
}
