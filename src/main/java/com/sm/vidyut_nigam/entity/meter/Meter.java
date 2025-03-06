package com.sm.vidyut_nigam.entity.meter;

import java.time.LocalDateTime;

import com.sm.vidyut_nigam.entity.consumer.Consumer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "meter")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meterId;

    private String meterName;
    private String meterAssetId;
    private String meterSerialNumber;
    private String meterSystemTitle;
    private Boolean meterSubscriptionMode;
    private String meterState;
    private String meterProtocol;

    private LocalDateTime meterInstallationDate;

    private LocalDateTime meterTestingDate;

    private String meterManufacturer;
    private String meterType;
    private String meterCommunicationType;
    private String meterHost;
    private Integer meterPort;
    private String meterSecurity;
    private String meterAuthenticationKey;
    private String meterBlockCipherKey;
    private String meterDedicatedKey;
    private String meterReaderPassword;
    private String meterUtilityPassword;
    private String meterFirmwarePassword;
    private String meterSimNumber;
    private String meterMobileNumber;
    private String meterNetworkProvider;
    private String meterIpAddress;
    private String meterModemNumber;
    private String meterModemManufacturer;
    private String meterModemIMEINumber;

    private LocalDateTime meterModemInstallationDate;

    private Double meterMctr;
    private Double meterMptr;
    private Double meterLctr;
    private Double meterLptr;
    private Double meterMultiplicationFactor;
    private Integer meterPulseRate;
    private Double meterLoad;
    private String meterAccuracyClass;
    private Integer meterNumberOfDigits;
    private Double meterImportReadingKwh;
    private Double meterImportReadingKvah;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meter_import_reading_unit_id", referencedColumnName = "consumerId", updatable = false)
    private Consumer meterConsumerId;
}