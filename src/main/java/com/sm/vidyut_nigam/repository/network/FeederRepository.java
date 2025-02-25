package com.sm.vidyut_nigam.repository.network;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.network.Feeder;

public interface FeederRepository extends JpaRepository<Feeder, Integer> {
    int countBySubStation_SubStationCode(int subStationCode);
    List<Feeder> findByFeederActive(boolean feederActive);
    List<Feeder> findBySubStation_SubStationCode(int subStationCode);
}
