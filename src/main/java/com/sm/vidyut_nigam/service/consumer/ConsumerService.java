package com.sm.vidyut_nigam.service.consumer;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;
import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;

public interface ConsumerService {

    String createConsumer(ConsumerRequestDTO consumerRequestDTO);

    Page<ConsumerResponseDTO> getConsumerBySectionCode(int sectionCode, int page, int size, String sortBy,
            String sortDirection);

    ConsumerResponseDTO getConsumerByConsumerCode(String consumerCode);

    Page<ConsumerResponseDTO> getConsumerByTransformerCode(int transformerCode, int page, int size, String sortBy,
            String sortDirection);

    String uploadConsumers(MultipartFile file);
}
