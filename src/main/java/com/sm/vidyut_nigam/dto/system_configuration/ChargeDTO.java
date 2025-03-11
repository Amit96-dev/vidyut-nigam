package com.sm.vidyut_nigam.dto.system_configuration;

import java.time.LocalDateTime;

import com.sm.vidyut_nigam.constant.ChargeType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class ChargeDTO {
    @NotBlank(message = "Charge code cannot be empty")
    private String chargeCode;

    @NotBlank(message = "Charge name cannot be empty")
    private String chargeName;

    @NotNull(message = "Charge status cannot be null")
    private boolean chargeStatus;

    @PastOrPresent(message = "Charge created at must be past or present date")
    private LocalDateTime chargeCreatedAt;

    @PastOrPresent(message = "Charge updated at must be past or present date")
    private LocalDateTime chargeUpdatedAt;

    @NotNull(message = "Charge type cannot be null")
    @Enumerated(EnumType.STRING)
    public ChargeType chargeType;
}
