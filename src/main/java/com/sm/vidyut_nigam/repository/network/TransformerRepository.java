package com.sm.vidyut_nigam.repository.network;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.network.Transformer;

public interface TransformerRepository extends JpaRepository<Transformer, Integer> {
    List<Transformer> findByTransformerActive(boolean transformerActive);

    List<Transformer> findByFeeder_FeederCode(int feederCode);

    int countByFeeder_FeederCode(int feederCode);
}
