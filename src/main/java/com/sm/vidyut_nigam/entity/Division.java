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
@Table(name = "divisions")
public class Division {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int divisionCode;

    @Column(length = 100, nullable = false)
    private String divisionName;

    @Column(length = 100, nullable = false)
    private String inChargeName;

    @Column(length = 50)
    private String designation;

    @Column(name = "circle_address", length = 300)
    private String address;

    @Column(length = 15)
    private String contactPhone;
    @Column(length = 255)
    private String contactEmail;
    private float longitude;
    private float latitude;
    private String divisionPicture;
    @ManyToOne
    @JoinColumn(name = "division_circle_id", referencedColumnName = "circleCode", nullable = false)
    private Circle circle;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime applicableFrom;
    private LocalDateTime applicableTo;
    @Column(nullable = false)
    private boolean active;
}
