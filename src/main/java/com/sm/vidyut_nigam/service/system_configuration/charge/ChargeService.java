package com.sm.vidyut_nigam.service.system_configuration.charge;

import java.util.List;

import com.sm.vidyut_nigam.dto.system_configuration.charge.ChargeDTO;
import com.sm.vidyut_nigam.dto.system_configuration.charge.ChargeResponseDTO;

public interface ChargeService {

    String createCharge(ChargeDTO chargeDTO);

    List<ChargeResponseDTO> showAllCharges();
}
