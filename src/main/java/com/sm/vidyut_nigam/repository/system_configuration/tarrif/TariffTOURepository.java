package com.sm.vidyut_nigam.repository.system_configuration.tarrif;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.system_configuration.tariff.TariffTOU;

public interface TariffTOURepository extends JpaRepository<TariffTOU, Long> {
    List<TariffTOU> findByTariffId(Long tariffId);
}