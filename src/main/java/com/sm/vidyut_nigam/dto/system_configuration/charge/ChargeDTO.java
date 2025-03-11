package com.sm.vidyut_nigam.dto.system_configuration.charge;

import com.sm.vidyut_nigam.constant.ChargeType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChargeDTO {
    @NotBlank(message = "Charge code cannot be empty")
    private String chargeCode;

    @NotBlank(message = "Charge name cannot be empty")
    private String chargeName;

    @NotNull(message = "Charge type cannot be null")
    @Enumerated(EnumType.STRING)
    public ChargeType chargeType;
}
