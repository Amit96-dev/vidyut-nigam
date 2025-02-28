package com.sm.vidyut_nigam.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "discoms")
public class Discom {

    @Id

    private int discomCode; // Discom code 1 character

    @Column(length = 100, nullable = false)
    private String discomName; // Distribution company name

    @Column(length = 100, nullable = false)
    private String discomInChargeName;
    @Column(length = 50)
    private String discomDesignation;

    @Column(name = "discom_address", length = 300)
    private String discomAddress;

    @Column(length = 15)
    private String discomContactPhone;

    @Column(length = 100)
    private String discomContactEmail;

    private float discomLongitude;
    private float discomLatitude;
    private String discomPicture;
    private String discomCreatedBy;
    private String discomUpdatedBy;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime discomCreatedAt;
    private LocalDateTime discomUpdatedAt;
    private LocalDateTime discomApplicableFrom;
    private LocalDateTime discomApplicableTo;
    @Column(nullable = false)
    private boolean discomActive;
}