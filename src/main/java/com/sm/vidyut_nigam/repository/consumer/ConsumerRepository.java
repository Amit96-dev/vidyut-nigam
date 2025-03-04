package com.sm.vidyut_nigam.repository.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.consumer.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, String> {

    int countBySection_SectionCode(int sectionCode);

    List<Consumer> findBySection_SectionCode(int sectionCode);

    List<Consumer> findByTransformer_TransformerCode(int transformerCode);
}
