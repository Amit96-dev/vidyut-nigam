package com.sm.vidyut_nigam.entity.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transformer")
public class Transformer {
    @Id
    private int transformerCode;
    
    @Column(name = "transformer_name", nullable = false, length = 100)
    private String transformerName;
    
    @Column(name = "transformer_longitude", nullable = false)
    private float transformerLongitude;
    
    @Column(name = "transformer_latitude", nullable = false)
    private float transformerLatitude;
    
    @Column(name = "transformer_picture")
    private String transformerPicture;
    
    @Column(name = "transformer_capacity", nullable = false)
    private int transformerCapacity;
    
    @Column(name = "transformer_created_at", nullable = false, updatable = false)
    private LocalDateTime transformerCreatedAt;
    
    @Column(name = "transformer_created_by", nullable = false, length = 50)
    private String transformerCreatedBy;
    
    @Column(name = "transformer_updated_at")
    private LocalDateTime transformerUpdatedAt;
    
    @Column(name = "transformer_updated_by", length = 50)
    private String transformerUpdatedBy;
    
    @Column(name = "transformer_applicable_from", nullable = false)
    private LocalDateTime transformerApplicableFrom;
    
    @Column(name = "transformer_applicable_to")
    private LocalDateTime transformerApplicableTo;
    
    @Column(name = "transformer_active", nullable = false)
    private boolean transformerActive;
    
    @Column(name = "transformer_manufacture_date", nullable = false)
    private LocalDate transformerManufactureDate;
    
    @Column(name = "transformer_installation_date", nullable = false)
    private LocalDate transformerInstallationDate;
    
    @Column(name = "transformer_maintenance_date")
    private LocalDate transformerMaintenanceDate;
    
    @Column(name = "transformer_oil_capacity", nullable = false)
    private float transformerOilCapacity;
    
    @ManyToOne
    @JoinColumn(name = "feeder_code", referencedColumnName = "feederCode", nullable = false)
    private Feeder feeder;
}
