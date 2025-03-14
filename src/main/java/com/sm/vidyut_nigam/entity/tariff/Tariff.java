package com.sm.vidyut_nigam.entity.tariff;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tariffs")
@Audited
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name; // Domestic, Commercial, Large, etc.

    @Column(nullable = false, length = 20)
    private String basis; // Day, Monthly

    @Column(nullable = false, length = 20)
    private String calculationBasis; // Slab, Flat, TOU

    @Column(nullable = false)
    private Double sanctionLoadFrom;

    @Column(nullable = false)
    private Double sanctionLoadTo;

    @Column(nullable = false)
    private Double minRechargeAmount;

    private LocalDateTime applicableFrom;

    @Column(nullable = false, length = 5)
    private String uom; // kW, kVA

    private Boolean status;

    private Boolean alertLastRecharge = false;
    private Boolean alertEmergencyCredit = false;
    private Boolean alertLoadDisconnection = false;
    private Boolean disconnectionLoad = false;
    private Boolean scBcCategory = false;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(columnDefinition = "TEXT")
    private String description;

}
