package com.sm.vidyut_nigam.entity.network;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transformer")
public class Transformer {
    @Id
    private int transformerCode;
    private String transformerName;
    private float transferLongitude;
    private float transferLatitude;
    private String transformerPicture;
    private int transformerCapacity;
    private LocalDateTime transformerCreatedAt;
    private String transformerCreatedBy;
    private LocalDateTime transformerUpdatedAt;
    private String transformerUpdatedBy;
    private LocalDateTime transformerApplicableFrom;
    private LocalDateTime transformerApplicableTo;
    private boolean transformerActive;

    private LocalDate transformerManufactureDate;
    private LocalDate transformerInstallationDate;
    private LocalDate transformerMaintenanceDate;
    private float transformerOilCapacity;

    @ManyToOne
    @JoinColumn(name = "feeder_code", referencedColumnName = "feederCode", nullable = false)
    private Feeder feeder;
}
