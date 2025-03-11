package com.sm.vidyut_nigam.entity.system_configuration;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import com.sm.vidyut_nigam.constant.ChargeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Charge {
    @Id
    private String chargeCode;
    private String chargeName;
    private boolean chargeStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime chargeCreatedAt;
    private LocalDateTime chargeUpdatedAt;

    @Enumerated(EnumType.STRING)
    public ChargeType chargeType;
}
