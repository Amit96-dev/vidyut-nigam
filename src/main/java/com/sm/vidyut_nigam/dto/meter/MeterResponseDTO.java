package com.sm.vidyut_nigam.dto.meter;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MeterResponseDTO {
    private String meterName;
    private String meterAssetId;
    private String meterSerialNumber;
    private String meterSystemTitle;
    private String meterSubscriptionMode;
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
    private Double meterMCTR;
    private Double meterMPTR;
    private Double meterLCTR;
    private Double meterLPTR;
    private Double meterMultiplicationFactor;
    private Integer meterPulseRate;
    private Double meterLoad;
    private String meterAccuracyClass;
    private Integer meterNumberOfDigits;
    private Double meterImportReadingKWH;
    private Double meterImportReadingKVAH;
    private String meterConsumerId;
}
