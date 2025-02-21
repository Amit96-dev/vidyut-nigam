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
@Table(name = "sections")
public class Section {
    @Id
    private int sectionCode;

    @Column(length = 100, nullable = false)
    private String sectionName;

    @Column(length = 100, nullable = false)
    private String sectionInChargeName;

    @Column(length = 50)
    private String sectionDesignation;

    @Column(length = 300)
    private String sectionAddress;

    @Column(length = 15)
    private String sectionContactPhone;

    @Column(length = 100)
    private String sectionContactEmail;

    private float sectionLongitude;
    private float sectionLatitude;
    private String sectionPicture;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime sectionCreatedAt;

    private String sectionCreatedBy;
    private LocalDateTime sectionUpdatedAt;
    private String sectionUpdatedBy;
    private LocalDateTime sectionApplicableFrom;
    private LocalDateTime sectionApplicableTo;

    @Column(nullable = false)
    private boolean sectionActive;

    @ManyToOne
    @JoinColumn(name = "sectionParentCode", referencedColumnName = "subDivisionCode", nullable = false)
    private SubDivision subDivision;
}
