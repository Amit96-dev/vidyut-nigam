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
@Table(name = "feeder")
public class Feeder {
    @Id
    private int feederCode;
    private String feederName;
    private String feederAddress;
    private float feederLongitude;
    private float feederLatitude;
    private String feederPicture;
    private int feederCapacity;
    private LocalDateTime feederCreatedAt;
    private String createdBy;
    private LocalDateTime feederUpdatedAt;
    private String updatedBy;
    private LocalDate feederApplicableFrom;
    private LocalDate feederApplicableTo;
    private boolean feederActive;

    @ManyToOne
    @JoinColumn(name = "sub_station", referencedColumnName = "subStationCode", updatable = false)
    private SubStation subStation;
}
