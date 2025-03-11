package com.sm.vidyut_nigam.entity.system_configuration;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryCode;
    private String categoryName;
    private double categoryEmergencyCredit;
    private boolean categoryStatus;
    @CreationTimestamp
    private LocalDateTime categoryCreatedAt;
    private LocalDateTime categoryUpdatedAt;
}
