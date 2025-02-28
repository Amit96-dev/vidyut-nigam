package com.sm.vidyut_nigam.dto.consumer;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ConsumerRequestDTO {
    private String consumerId;
    
    @NotNull(message = "Consumer code cannot be null")
    private long consumerCode;
    
    @NotBlank(message = "Consumer number cannot be blank")
    private String consumerNumber;
    
    private String consumerOrganizationId;
    
    private String consumerNetworkId;
    
    @NotBlank(message = "Consumer name cannot be blank")
    private String consumerName;
    
    @Pattern(regexp = "^\\d{10}$", message = "Invalid WhatsApp number")
    private String consumerWhatsappNumber;
    
    @NotBlank(message = "Consumer address cannot be blank")
    private String consumerAddress;
    
    @Pattern(regexp = "^\\d{10}$", message = "Invalid contact phone number")
    private String consumerContactPhone;
    
    @Email(message = "Invalid email format")
    private String consumerContactEmail;
    
    private float consumerLongitude;
    
    private float consumerLatitude;
    
    private String consumerPicture;
    
    @NotBlank(message = "Consumer tariff cannot be blank")
    private String consumerTariff;
    
    @Positive(message = "Connected load must be positive")
    private double consumerConnectedLoad;
    
    private LocalDateTime consumerDateOfSupply;
    
    @PositiveOrZero(message = "Security deposit amount cannot be negative")
    private Double consumerSecurityDepositAmount;
    
    private LocalDateTime consumerSecurityDepositDate;
    
    @NotBlank(message = "Consumer status cannot be blank")
    private String consumerStatus;
    
    private String consumerMeterNumber;
    
    private String consumerMeterStatus;
    
    private LocalDateTime consumerCreatedAt;
    
    private String consumerCreatedBy;
    
    private LocalDateTime consumerUpdatedAt;
    
    private String consumerUpdatedBy;
    
    private LocalDate consumerApplibleFrom;
    
    private LocalDate consumerApplicableTo;
    
    private boolean consumerActive;
    
    @PositiveOrZero(message = "Arrear amount cannot be negative")
    private double consumerArrearAmount;
    
    @NotNull(message = "Discom ID cannot be null")
    private int discomId;
    
    @NotNull(message = "Circle ID cannot be null")
    private int circleId;
    
    @NotNull(message = "Division ID cannot be null")
    private int divisionId;
    
    @NotNull(message = "Sub-Division ID cannot be null")
    private int subDivisionId;
    
    @NotNull(message = "Section ID cannot be null")
    private int sectionId;
    
    @NotNull(message = "Sub-Station ID cannot be null")
    private int subStationId;
    
    @NotNull(message = "Feeder ID cannot be null")
    private int feederId;
    
    @NotNull(message = "Transformer ID cannot be null")
    private int transformerId;
}
