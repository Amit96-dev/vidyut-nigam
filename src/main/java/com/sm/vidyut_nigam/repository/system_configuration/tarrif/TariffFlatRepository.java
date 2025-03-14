package com.sm.vidyut_nigam.repository.system_configuration.tarrif;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.system_configuration.tariff.TariffFlat;

public interface TariffFlatRepository extends JpaRepository<TariffFlat, Long> {
    List<TariffFlat> findByTariffId(Long tariffId);
}
