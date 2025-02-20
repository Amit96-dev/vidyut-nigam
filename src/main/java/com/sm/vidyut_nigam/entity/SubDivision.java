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
@Table(name = "sub_divisions")
public class SubDivision {
    @Id
    private int subDivisionCode;

    @Column(length = 100, nullable = false)
    private String subDivisionName;

    @Column(length = 100, nullable = false)
    private String subDivisionInChargeName;

    @Column(length = 50)
    private String subDivisionDesignation;

    @Column(length = 300)
    private String subDivisionAddress;

    @Column(length = 15)
    private String subDivisionContactPhone;

    @Column(length = 100)
    private String subDivisionContactEmail;

    private float subDivisionLongitude;
    private float subDivisionLatitude;
    private String subDivisionPicture;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime subDivisionCreatedAt;
    private String subDivisionCreatedBy;
    private LocalDateTime subDivisionUpdatedAt;
    private String subDivisionUpdatedBy;
    private LocalDateTime subDivisionApplicableFrom;
    private LocalDateTime subDivisionApplicableTo;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "divisionCode", referencedColumnName = "divisionCode", nullable = false)
    private Division division;
}
