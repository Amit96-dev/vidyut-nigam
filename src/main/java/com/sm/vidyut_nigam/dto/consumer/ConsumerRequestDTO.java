package com.sm.vidyut_nigam.dto.consumer;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConsumerRequestDTO {

    @NotBlank(message = "Consumer ID is required")
    private String consumerId;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Connection type is required")
    private String consumerConnectionType;

    @NotBlank(message = "Account number is required")
    private String consumerAccountNo;

    private String consumerLegacyConsumerNo;

    @NotBlank(message = "Consumer name is required")
    private String consumerName;

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String consumerContactNo;

    @Email(message = "Invalid email format")
    private String consumerEmail;

    private String consumerCommunicationPreference;

    private String consumerConnectionPhase;

    private String consumerIndustryName;

    private String consumerPaymentMode;

    @NotBlank(message = "Consumer type is required")
    private String consumerType;

    @NotBlank(message = "Category is required")
    private String consumerCategory;

    private String consumerPurpose;

    private String consumerTariff;

    private String consumerMetering;

    @PositiveOrZero(message = "Contract demand must be zero or positive")
    private Double consumerContractDemand;

    private String consumerContractDemandUOM;

    @PositiveOrZero(message = "Sanction load must be zero or positive")
    private Double consumerSanctionLoad;

    private String consumerSanctionLoadUOM;

    private Double consumerSupplyVoltageKV;

    private LocalDate consumerConnectionDate;

    private String consumerConnectionStatus;

    private LocalDate consumerLastDisconnectedDate;

    private LocalDate consumerLastReconnectedDate;

    private LocalDate consumerConnectionClosedDate;

    private Boolean consumerTemporary;

    private Double consumerMinBillDemand;

    private String consumerBillingId;

    private String consumerMeterDevices;

    private String consumerSearchLocation;

    private Double consumerLongitude;

    private Double consumerLatitude;

    private String consumerSiteAddress;

    private String consumerSiteState;

    private String consumerSiteCity;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String consumerSitePinCode;

    @Email(message = "Invalid email format")
    private String consumerSiteEmail;

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String consumerSiteContactNo;

    private String consumerBillAddress;

    private String consumerBillState;

    private String consumerBillCity;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String consumerBillPinCode;

    @Email(message = "Invalid email format")
    private String consumerBillEmail;

    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String consumerBillContactNo;

    private String consumerExistingMeterNo;

    private String consumerExistingMeterType;

    private Double consumerExistingMeterMF;

    private String consumerExistingMeterSealStatus;

    private Double consumerExistingConsumerLoad;

    private Double consumerLastMeterReading;

    private String consumerLineLTCTRatio;

    private String consumerExistingMeterLocation;

    private Boolean consumerChangeOfMeterLocationEnvisaged;

    private String consumerMeterBoxDimensions;

    private Integer consumerNoOfMetersAtSingleLocation;

    private String consumerMeterLegalStatus;

    private Boolean consumerClubbingOfMeters;

    private LocalDate consumerDateOfConnection;

    private String consumerRemarks;

    @NotBlank(message = "Section ID is required")
    private String consumerSectionId;

    @NotBlank(message = "Transformer ID is required")
    private String consumerTransformerId;
}
