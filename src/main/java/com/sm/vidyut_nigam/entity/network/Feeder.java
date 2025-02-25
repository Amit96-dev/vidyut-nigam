package com.sm.vidyut_nigam.entity.network;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feeder")
public class Feeder {

    @Id
    private int feederCode;

    @Column(name = "feeder_name", nullable = false, length = 100)
    private String feederName;

    @Column(name = "feeder_address", length = 255)
    private String feederAddress;

    @Column(name = "feeder_longitude")
    private float feederLongitude;

    @Column(name = "feeder_latitude")
    private float feederLatitude;

    @Column(name = "feeder_picture", length = 255)
    private String feederPicture;

    @Column(name = "feeder_capacity", nullable = false)
    private int feederCapacity;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime feederCreatedAt;

    @Column(name = "created_by", nullable = false, length = 100)
    private String feederCreatedBy;

    @Column(name = "updated_at")
    private LocalDateTime feederUpdatedAt;

    @Column(name = "updated_by", length = 100)
    private String feederUpdatedBy;

    @Column(name = "applicable_from")
    private LocalDate feederApplicableFrom;

    @Column(name = "applicable_to")
    private LocalDate feederApplicableTo;

    @Column(name = "active", nullable = false)
    private boolean feederActive;

    @ManyToOne
    @JoinColumn(name = "substation_code", referencedColumnName = "substation_code", nullable = false)
    private SubStation subStation;
}
