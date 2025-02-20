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
@Table(name = "circles")
public class Circle {

    @Id
    private int circleCode; // Circle code 1 character

    @Column(length = 100, nullable = false)
    private String circleName;
    @Column(length = 100)
    private String circleInChargeName; // Circle incharge name
    @Column(length = 50)
    private String circleDesignation;
    @Column(name = "circle_address", length = 300)
    private String circleAddress;
    @Column(length = 15)
    private String circleContactPhone;
    @Column(length = 100)
    private String circleContactEmail;
    private float circleLongitude;
    private float circleLatitude;
    private String circlePicture;

    @ManyToOne
    @JoinColumn(name = "circleParentCode", referencedColumnName = "discomCode", nullable = false)
    private Discom discom;

    private String circleCreatedBy;
    private String circleUpdatedBy;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime circleCreatedAt;
    private LocalDateTime circleUpdatedAt;
    private LocalDateTime circleApplicableFrom;
    private LocalDateTime circleApplicableTo;
    @Column(nullable = false)
    private boolean circleActive;
}
