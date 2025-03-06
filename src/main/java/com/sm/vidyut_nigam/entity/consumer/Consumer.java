package com.sm.vidyut_nigam.entity.consumer;

import java.time.LocalDateTime;

import com.sm.vidyut_nigam.entity.Section;
import com.sm.vidyut_nigam.entity.network.Transformer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "consumer")
public class Consumer {

    @Id
    @Column(unique = true, nullable = false)
    private String consumerId; // Provided manually, not auto-generated

    @Column(name = "type")
    private String type;

    @Column(name = "consumer_connection_type")
    private String consumerConnectionType;

    @Column(name = "consumer_account_no")
    private String consumerAccountNo;

    @Column(name = "consumer_legacy_consumer_no")
    private String consumerLegacyConsumerNo;

    @Column(name = "consumer_name")
    private String consumerName;

    @Column(name = "consumer_contact_no")
    private String consumerContactNo;

    @Column(name = "consumer_email")
    private String consumerEmail;

    @Column(name = "consumer_communication_preference")
    private String consumerCommunicationPreference;

    @Column(name = "consumer_connection_phase")
    private String consumerConnectionPhase;

    @Column(name = "consumer_industry_name")
    private String consumerIndustryName;

    @Column(name = "consumer_payment_mode")
    private String consumerPaymentMode;

    @Column(name = "consumer_type")
    private String consumerType;

    @Column(name = "consumer_category")
    private String consumerCategory;

    @Column(name = "consumer_purpose")
    private String consumerPurpose;

    @Column(name = "consumer_tariff")
    private String consumerTariff;

    @Column(name = "consumer_metering")
    private String consumerMetering;

    @Column(name = "consumer_contract_demand")
    private Double consumerContractDemand;

    @Column(name = "consumer_contract_demand_uom")
    private String consumerContractDemandUOM;

    @Column(name = "consumer_sanction_load")
    private Double consumerSanctionLoad;

    @Column(name = "consumer_sanction_load_uom")
    private String consumerSanctionLoadUOM;

    @Column(name = "consumer_supply_voltage_kv")
    private Double consumerSupplyVoltageKV;

    @Column(name = "consumer_connection_date")
    private LocalDateTime consumerConnectionDate;

    @Column(name = "consumer_connection_status")
    private String consumerConnectionStatus;

    @Column(name = "consumer_last_disconnected_date")
    private LocalDateTime consumerLastDisconnectedDate;

    @Column(name = "consumer_last_reconnected_date")
    private LocalDateTime consumerLastReconnectedDate;

    @Column(name = "consumer_connection_closed_date")
    private LocalDateTime consumerConnectionClosedDate;

    @Column(name = "consumer_temporary")
    private Boolean consumerTemporary;

    @Column(name = "consumer_min_bill_demand")
    private Double consumerMinBillDemand;

    @Column(name = "consumer_billing_id")
    private String consumerBillingId;

    @Column(name = "consumer_meter_devices")
    private String consumerMeterDevices;

    @Column(name = "consumer_search_location")
    private String consumerSearchLocation;

    @Column(name = "consumer_longitude")
    private Double consumerLongitude;

    @Column(name = "consumer_latitude")
    private Double consumerLatitude;

    @Column(name = "consumer_site_address")
    private String consumerSiteAddress;

    @Column(name = "consumer_site_state")
    private String consumerSiteState;

    @Column(name = "consumer_site_city")
    private String consumerSiteCity;

    @Column(name = "consumer_site_pincode")
    private String consumerSitePinCode;

    @Column(name = "consumer_site_email")
    private String consumerSiteEmail;

    @Column(name = "consumer_site_contact_no")
    private String consumerSiteContactNo;

    @Column(name = "consumer_bill_address")
    private String consumerBillAddress;

    @Column(name = "consumer_bill_state")
    private String consumerBillState;

    @Column(name = "consumer_bill_city")
    private String consumerBillCity;

    @Column(name = "consumer_bill_pincode")
    private String consumerBillPinCode;

    @Column(name = "consumer_bill_email")
    private String consumerBillEmail;

    @Column(name = "consumer_bill_contact_no")
    private String consumerBillContactNo;

    @Column(name = "consumer_existing_meter_no")
    private String consumerExistingMeterNo;

    @Column(name = "consumer_existing_meter_type")
    private String consumerExistingMeterType;

    @Column(name = "consumer_existing_meter_mf")
    private Double consumerExistingMeterMF;

    @Column(name = "consumer_existing_meter_seal_status")
    private String consumerExistingMeterSealStatus;

    @Column(name = "consumer_existing_consumer_load")
    private Double consumerExistingConsumerLoad;

    @Column(name = "consumer_last_meter_reading")
    private Double consumerLastMeterReading;

    @Column(name = "consumer_line_lt_ct_ratio")
    private String consumerLineLTCTRatio;

    @Column(name = "consumer_existing_meter_location")
    private String consumerExistingMeterLocation;

    @Column(name = "consumer_change_of_meter_location_envisaged")
    private Boolean consumerChangeOfMeterLocationEnvisaged;

    @Column(name = "consumer_meter_box_dimensions")
    private String consumerMeterBoxDimensions;

    @Column(name = "consumer_no_of_meters_at_single_location")
    private Integer consumerNoOfMetersAtSingleLocation;

    @Column(name = "consumer_meter_legal_status")
    private String consumerMeterLegalStatus;

    @Column(name = "consumer_clubbing_of_meters")
    private Boolean consumerClubbingOfMeters;

    @Column(name = "consumer_date_of_connection")
    private LocalDateTime consumerDateOfConnection;

    @Column(name = "consumer_remarks")
    private String consumerRemarks;

    // Relationship with Section (Attach to Organisation)
    @ManyToOne
    @JoinColumn(name = "section", referencedColumnName = "sectionCode")
    private Section section;

    // Relationship with Transformer (Attach to Network)
    @ManyToOne
    @JoinColumn(name = "transformer", referencedColumnName = "transformerCode")
    private Transformer transformer;
}
