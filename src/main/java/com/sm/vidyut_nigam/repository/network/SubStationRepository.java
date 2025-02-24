package com.sm.vidyut_nigam.repository.network;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.network.SubStation;

public interface SubStationRepository extends JpaRepository<SubStation, Integer> {
    List<SubStation> findBySubStationActive(Boolean subStationActive);
    List<SubStation> findBySubStationNameContainingIgnoreCase(String subStationName);
}
