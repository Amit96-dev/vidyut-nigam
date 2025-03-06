package com.sm.vidyut_nigam.dto.meter;

import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MeterRequestDTO {
    private Long meterId; // Removed @NotNull because it's auto-generated

    @NotBlank(message = "Meter name is required")
    private String meterName;

    @NotBlank(message = "Meter asset ID is required")
    private String meterAssetId;

    @NotBlank(message = "Meter serial number is required")
    private String meterSerialNumber;

    private String meterSystemTitle;

    @NotNull(message = "Subscription mode is required")
    private Boolean meterSubscriptionMode;

    @NotBlank(message = "Meter state is required")
    private String meterState;

    @NotBlank(message = "Meter protocol is required")
    private String meterProtocol;

    @PastOrPresent(message = "Installation date cannot be in the future")
    private LocalDateTime meterInstallationDate;

    @PastOrPresent(message = "Testing date cannot be in the future")
    private LocalDateTime meterTestingDate;

    @NotBlank(message = "Manufacturer is required")
    private String meterManufacturer;

    @NotBlank(message = "Meter type is required")
    private String meterType;

    private String meterCommunicationType;

    private String meterHost;

    @Min(value = 1, message = "Port must be a positive number")
    private Integer meterPort;

    private String meterSecurity;

    private String meterAuthenticationKey;
    private String meterBlockCipherKey;
    private String meterDedicatedKey;

    private String meterReaderPassword;
    private String meterUtilityPassword;
    private String meterFirmwarePassword;

    @Pattern(regexp = "\\d+", message = "SIM number must contain only digits")
    private String meterSimNumber;

    @Pattern(regexp = "\\d{10,15}", message = "Mobile number must be between 10 and 15 digits")
    private String meterMobileNumber;

    private String meterNetworkProvider;

    @Pattern(regexp = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$", message = "Invalid IP address format")
    private String meterIpAddress;

    private String meterModemNumber;
    private String meterModemManufacturer;

    @Pattern(regexp = "\\d+", message = "IMEI number must contain only digits")
    private String meterModemIMEINumber;

    @PastOrPresent(message = "Modem installation date cannot be in the future")
    private LocalDateTime meterModemInstallationDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "MCTR must be greater than zero")
    private Double meterMctr;

    @DecimalMin(value = "0.0", inclusive = false, message = "MPTR must be greater than zero")
    private Double meterMptr;

    @DecimalMin(value = "0.0", inclusive = false, message = "LCTR must be greater than zero")
    private Double meterLctr;

    @DecimalMin(value = "0.0", inclusive = false, message = "LPTR must be greater than zero")
    private Double meterLptr;

    @DecimalMin(value = "0.1", message = "Multiplication factor must be at least 0.1")
    private Double meterMultiplicationFactor;

    @Min(value = 1, message = "Pulse rate must be a positive number")
    private Integer meterPulseRate;

    @DecimalMin(value = "0.0", message = "Load must be at least 0.0")
    private Double meterLoad;

    private String meterAccuracyClass;

    @Min(value = 1, message = "Number of digits must be at least 1")
    private Integer meterNumberOfDigits;

    @DecimalMin(value = "0.0", message = "Import Reading KWH must be at least 0.0")
    private Double meterImportReadingKwh;

    @DecimalMin(value = "0.0", message = "Import Reading KVAH must be at least 0.0")
    private Double meterImportReadingKvah;

    @NotBlank(message = "Consumer ID is required") // Changed to String
    private String meterConsumerId;
}
