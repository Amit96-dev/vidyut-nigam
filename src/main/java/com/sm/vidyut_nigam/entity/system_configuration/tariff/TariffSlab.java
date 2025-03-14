package com.sm.vidyut_nigam.entity.system_configuration.tariff;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tariff_slabs")
public class TariffSlab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private Tariff tariff; // Foreign key reference

    @Column(nullable = false)
    private Double fromUnit;

    @Column(nullable = false)
    private Double toUnit;

    @Column(precision = 10, scale = 2)
    private BigDecimal unitRate;

    @Column(columnDefinition = "TEXT")
    private String calculation; // Formula for calculation
}
