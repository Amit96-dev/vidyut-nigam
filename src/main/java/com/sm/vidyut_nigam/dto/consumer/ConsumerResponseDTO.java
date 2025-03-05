package com.sm.vidyut_nigam.dto.consumer;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ConsumerResponseDTO {

    private String consumerId;
    private String type;
    private String consumerConnectionType;
    private String consumerAccountNo;
    private String consumerLegacyConsumerNo;
    private String consumerName;
    private String consumerContactNo;
    private String consumerEmail;
    private String consumerCommunicationPreference;
    private String consumerConnectionPhase;
    private String consumerIndustryName;
    private String consumerPaymentMode;
    private String consumerType;
    private String consumerCategory;
    private String consumerPurpose;
    private String consumerTariff;
    private String consumerMetering;
    private Double consumerContractDemand;
    private String consumerContractDemandUOM;
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
    private String consumerSitePinCode;
    private String consumerSiteEmail;
    private String consumerSiteContactNo;
    private String consumerBillAddress;
    private String consumerBillState;
    private String consumerBillCity;
    private String consumerBillPinCode;
    private String consumerBillEmail;
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

    // IDs of related entities instead of full objects to avoid unnecessary nesting
    private int section;
    private int transformer;
}
