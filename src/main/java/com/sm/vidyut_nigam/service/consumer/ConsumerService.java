package com.sm.vidyut_nigam.service.consumer;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;
import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;

public interface ConsumerService {

    String createConsumer(ConsumerRequestDTO consumerRequestDTO);

    List<ConsumerResponseDTO> getConsumerBySectionCode(int sectionCode);

    ConsumerResponseDTO getConsumerByConsumerCode(String consumerCode);

    List<ConsumerResponseDTO> getConsumerByTransformerCode(int transformerCode);

    String uploadConsumers(MultipartFile file);
}
