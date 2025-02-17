package com.sm.vidyut_nigam.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int circleId;

    private int circleCode; // Circle code 1 character

    @Column(length = 100, nullable = false)
    private String circleName;
    @Column(length = 100)
    private String inChargeName; // Distribution company name
    @Column(length = 50)
    private String designation;
    @Column(name = "discom_address", length = 300)
    private String address;
    @Column(length = 15)
    private String contactPhone;
    @Column(length = 100)
    private String contactEmail;
    private float longitude;
    private float latitude;
    private String circlePicture;

    @ManyToOne
    @JoinColumn(name = "parentOrganizationId", referencedColumnName = "discomCode", nullable = false)
    private Discom discom;

    private String createdBy;
    private String updatedBy;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime applicableFrom;
    private LocalDateTime applicableTo;
    @Column(nullable = false)
    private boolean active;
}
