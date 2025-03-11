package com.sm.vidyut_nigam.repository.consumer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.vidyut_nigam.entity.consumer.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, String> {

    int countBySection_SectionCode(int sectionCode);

    Page<Consumer> findBySection_SectionCode(Pageable pageable, int sectionCode);

    Page<Consumer> findByTransformer_TransformerCode(Pageable pageable, int transformerCode);

}
