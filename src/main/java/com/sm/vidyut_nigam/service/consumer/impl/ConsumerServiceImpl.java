package com.sm.vidyut_nigam.service.consumer.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;
import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;
import com.sm.vidyut_nigam.entity.consumer.Consumer;
import com.sm.vidyut_nigam.repository.consumer.ConsumerRepository;
import com.sm.vidyut_nigam.service.consumer.ConsumerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository consumerRepository;

    private final ModelMapper mapper;

    @Override
    public String createConsumer(ConsumerRequestDTO consumerRequestDTO) {
        try {
            String code = String.format("%04d",
                    consumerRepository.countBySection_SectionCode(consumerRequestDTO.getConsumerSectionId()));
            String consumerCode = Integer.toString(consumerRequestDTO.getConsumerSectionId()) + (code + 1);
            consumerRequestDTO.setConsumerId(consumerCode);
            consumerRequestDTO.setConsumerAccountNo(consumerCode);
            consumerRepository.save(mapper.map(consumerRequestDTO, Consumer.class));
            return "Consumer created Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<ConsumerResponseDTO> getConsumerBySectionCode(int sectionCode) {
        System.out.println("***********sectionCode: " + sectionCode);
        List<Consumer> consumerList = consumerRepository.findBySection_SectionCode(sectionCode);
        System.out.println(consumerList);
        List<ConsumerResponseDTO> consumerDTOList = consumerList.stream()
                .map(consumer -> mapper.map(consumer, ConsumerResponseDTO.class))
                .toList();
        return consumerDTOList;
    }

    @Override
    public ConsumerResponseDTO getConsumerByConsumerCode(String consumerCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConsumerByConsumerCode'");
    }

    @Override
    public List<ConsumerResponseDTO> getConsumerByTransformerCode(int transformerCode) {
        System.out.println("***********sectionCode: " + transformerCode);
        List<Consumer> consumerList = consumerRepository.findByTransformer_TransformerCode(transformerCode);
        System.out.println(consumerList);
        List<ConsumerResponseDTO> consumerDTOList = consumerList.stream()
                .map(consumer -> mapper.map(consumer, ConsumerResponseDTO.class))
                .toList();
        return consumerDTOList;
    }

}
