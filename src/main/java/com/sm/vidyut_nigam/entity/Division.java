package com.sm.vidyut_nigam.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "divisions")
public class Division {

    @Id
    private int divisionCode;

    @Column(length = 100, nullable = false)
    private String divisionName;

    @Column(length = 100, nullable = false)
    private String divisionInChargeName;

    @Column(length = 50)
    private String divisionDesignation;

    @Column(name = "circle_address", length = 300)
    private String divisionAddress;

    @Column(length = 15)
    private String divisionContactPhone;
    @Column(length = 255)
    private String divisionContactEmail;
    private float divisionLongitude;
    private float divisionLatitude;
    private String divisionPicture;
    @ManyToOne
    @JoinColumn(name = "divisionParentCode", referencedColumnName = "circleCode", nullable = false)
    private Circle circle;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime divisionCreatedAt;

    private String divisionCreatedBy;
    private LocalDateTime divisionUpdatedAt;
    private String divisionUpdatedBy;
    private LocalDateTime divisionApplicableFrom;
    private LocalDateTime divisionApplicableTo;
    @Column(nullable = false)
    private boolean divisionActive;
}
