package com.sm.vidyut_nigam.repository.system_configuration.tarrif;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.system_configuration.tariff.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
