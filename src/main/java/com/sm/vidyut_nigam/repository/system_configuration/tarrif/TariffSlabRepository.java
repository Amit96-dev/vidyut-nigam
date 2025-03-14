package com.sm.vidyut_nigam.repository.system_configuration.tarrif;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.system_configuration.tariff.TariffSlab;

public interface TariffSlabRepository extends JpaRepository<TariffSlab, Long> {
    List<TariffSlab> findByTariffId(Long tariffId);
}