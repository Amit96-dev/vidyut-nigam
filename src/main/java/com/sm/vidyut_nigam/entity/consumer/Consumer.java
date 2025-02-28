package com.sm.vidyut_nigam.entity.consumer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.sm.vidyut_nigam.entity.Circle;
import com.sm.vidyut_nigam.entity.Discom;
import com.sm.vidyut_nigam.entity.Division;
import com.sm.vidyut_nigam.entity.Section;
import com.sm.vidyut_nigam.entity.SubDivision;
import com.sm.vidyut_nigam.entity.network.Feeder;
import com.sm.vidyut_nigam.entity.network.SubStation;
import com.sm.vidyut_nigam.entity.network.Transformer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "consumer")
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumer_id")
    private String consumerId;

    @Column(name = "consumer_code")
    private long consumerCode;

    @Column(name = "consumer_number")
    private String consumerNumber;

    @Column(name = "consumer_organization_id")
    private String consumerOrganizationId;

    @Column(name = "consumer_network_id")
    private String consumerNetworkId;

    @Column(name = "consumer_name")
    private String consumerName;

    @Column(name = "consumer_whatsapp_number")
    private String consumerWhatsappNumber;

    @Column(name = "consumer_address")
    private String consumerAddress;

    @Column(name = "consumer_contact_phone")
    private String consumerContactPhone;

    @Column(name = "consumer_contact_email")
    private String consumerContactEmail;

    @Column(name = "consumer_longitude")
    private float consumerLongitude;

    @Column(name = "consumer_latitude")
    private float consumerLatitude;

    @Column(name = "consumer_picture")
    private String consumerPicture;

    @Column(name = "consumer_tariff")
    private String consumerTariff;

    @Column(name = "consumer_connected_load")
    private double consumerConnectedLoad;

    @Column(name = "consumer_date_of_supply")
    private LocalDateTime consumerDateOfSupply;

    @Column(name = "consumer_security_deposit_amount")
    private Double consumerSecurityDepositAmount;

    @Column(name = "consumer_security_deposit_date")
    private LocalDateTime consumerSecurityDepositDate;

    @Column(name = "consumer_status")
    private String consumerStatus;

    @Column(name = "consumer_meter_number")
    private String consumerMeterNumber;

    @Column(name = "consumer_meter_status")
    private String consumerMeterStatus;

    @CreationTimestamp
    @Column(name = "consumer_created_at", nullable = false, updatable = false)
    private LocalDateTime consumerCreatedAt;

    @Column(name = "consumer_created_by")
    private String consumerCreatedBy;

    @Column(name = "consumer_updated_at")
    private LocalDateTime consumerUpdatedAt;

    @Column(name = "consumer_updated_by")
    private String consumerUpdatedBy;

    @Column(name = "consumer_applicable_from")
    private LocalDate consumerApplibleFrom;

    @Column(name = "consumer_applicable_to")
    private LocalDate consumerApplicableTo;

    @Column(name = "consumer_active")
    private boolean consumerActive;

    @Column(name = "consumer_arrear_amount")
    private double consumerArrearAmount;

    @ManyToOne
    @JoinColumn(name = "discom_id", referencedColumnName = "discomCode")
    private Discom discomId;

    @ManyToOne
    @JoinColumn(name = "circle_id", referencedColumnName = "circleCode")
    private Circle circleId;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionCode")
    private Division divisionId;

    @ManyToOne
    @JoinColumn(name = "sub_division_id", referencedColumnName = "subDivisionCode")
    private SubDivision subDivisionId;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "sectionCode")
    private Section sectionId;

    @ManyToOne
    @JoinColumn(name = "substation_code", referencedColumnName = "substation_code")
    private SubStation subStationId;

    @ManyToOne
    @JoinColumn(name = "feeder_id", referencedColumnName = "feederCode")
    private Feeder feederId;

    @ManyToOne
    @JoinColumn(name = "transformer_id", referencedColumnName = "transformerCode")
    private Transformer transformerId;
}