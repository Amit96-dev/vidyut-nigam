package com.sm.vidyut_nigam.repository.meter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.meter.Meter;

public interface MeterRepository extends JpaRepository<Meter, Long> {

    boolean existsByMeterConsumerId_ConsumerId(String consumerId);

}
