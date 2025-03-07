package com.sm.vidyut_nigam.entity.network;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "substation")
public class SubStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "substation_code", nullable = false, unique = true)
    private int subStationCode;

    @Column(name = "substation_name", nullable = false, length = 100)
    private String subStationName;

    @Column(name = "in_charge_name", length = 100)
    private String subStationInChargeName;

    @Column(name = "designation", length = 50)
    private String subStationDesignation;

    @Column(name = "address", nullable = false, length = 255)
    private String subStationAddress;

    @Column(name = "longitude")
    private float subStationLongitude;

    @Column(name = "latitude")
    private float subStationLatitude;

    @Column(name = "picture", length = 255)
    private String subStationPicture;

    @Column(name = "capacity", nullable = false)
    private int subStationCapacity; // in MW or MVA

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime subStationCreatedAt;

    @Column(name = "created_by", nullable = false, length = 100)
    private String subStationCreatedBy;

    @Column(name = "updated_by", length = 100)
    private String subStationUpdatedBy;

    @Column(name = "updated_dt")
    private LocalDateTime subStationUpdatedDt;

    @Column(name = "applicable_from")
    private LocalDate subStationApplicableFrom;

    @Column(name = "applicable_to")
    private LocalDate subStationApplicableTo;

    @Column(name = "active", nullable = false)
    private boolean subStationActive;
}
