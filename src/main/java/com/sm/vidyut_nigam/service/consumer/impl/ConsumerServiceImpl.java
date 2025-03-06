package com.sm.vidyut_nigam.service.consumer.impl;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;
import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;
import com.sm.vidyut_nigam.entity.Section;
import com.sm.vidyut_nigam.entity.consumer.Consumer;
import com.sm.vidyut_nigam.entity.network.Transformer;
import com.sm.vidyut_nigam.repository.SectionRepository;
import com.sm.vidyut_nigam.repository.consumer.ConsumerRepository;
import com.sm.vidyut_nigam.repository.network.TransformerRepository;
import com.sm.vidyut_nigam.service.consumer.ConsumerService;
import com.sm.vidyut_nigam.service.consumer.excel.ConsumerExcelHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ConsumerRepository consumerRepository;

    private final ModelMapper mapper;

    private final SectionRepository sectionRepository;

    private final TransformerRepository transformerRepository;

    private final Random random = new Random();

    @Override
    public String createConsumer(ConsumerRequestDTO consumerRequestDTO) {
        try {
            int cod = consumerRepository.countBySection_SectionCode(consumerRequestDTO.getSection()) + 1;
            String code = String.format("%07d", cod);
            String consumerCode = Integer.toString(consumerRequestDTO.getSection()) + code
                    + (char) ('A' + random.nextInt(26));
            consumerRequestDTO.setConsumerId(generateConsumerId());
            consumerRequestDTO.setConsumerAccountNo(consumerCode);
            Consumer consumer = mapper.map(consumerRequestDTO, Consumer.class);
            Section section = sectionRepository.findById(consumerRequestDTO.getSection())
                    .orElseThrow(() -> new RuntimeException("Section not found"));
            consumer.setSection(section);

            Transformer transformer = transformerRepository.findById(consumerRequestDTO.getTransformer())
                    .orElseThrow(() -> new RuntimeException("Transformer not found"));
            consumer.setTransformer(transformer);
            consumerRepository.save(consumer);
            return "Consumer created Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<ConsumerResponseDTO> getConsumerBySectionCode(int sectionCode) {
        try {
            List<Consumer> consumerList = consumerRepository.findBySection_SectionCode(sectionCode);
            System.out.println("Fetched Consumers: " + consumerList.size());

            return consumerList.stream()
                    .map(consumer -> mapper.map(consumer, ConsumerResponseDTO.class))
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Error fetching consumers for sectionCode: " + e.getMessage());
        }
    }

    @Override
    public ConsumerResponseDTO getConsumerByConsumerCode(String consumerCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConsumerByConsumerCode'");
    }

    @Override
    public List<ConsumerResponseDTO> getConsumerByTransformerCode(int transformerCode) {
        List<Consumer> consumerList = consumerRepository.findByTransformer_TransformerCode(transformerCode);
        System.out.println(consumerList);
        List<ConsumerResponseDTO> consumerDTOList = consumerList.stream()
                .map(consumer -> mapper.map(consumer, ConsumerResponseDTO.class))
                .toList();
        return consumerDTOList;
    }

    public String uploadConsumers(MultipartFile file) {
        if (!ConsumerExcelHelper.hasExcelFormat(file)) {
            throw new RuntimeException("Invalid file format. Please upload an Excel file.");
        }

        try {
            List<ConsumerRequestDTO> consumerDTOs = ConsumerExcelHelper.excelToConsumers(file.getInputStream());

            System.out.println("Consumers: " + consumerDTOs);

            for (ConsumerRequestDTO dto : consumerDTOs) {
                // Validate Section
                if (dto.getSection() == null || dto.getSection() <= 0) {
                    throw new RuntimeException("Invalid section ID: " + dto.getSection());
                }

                // Validate Transformer
                if (dto.getTransformer() == null || dto.getTransformer() <= 0) {
                    throw new RuntimeException("Invalid transformer ID: " + dto.getTransformer());
                }

                // Generate Unique Consumer Code
                int cod = consumerRepository.countBySection_SectionCode(dto.getSection()) + 1;
                String code = String.format("%07d", cod);
                String consumerCode = dto.getSection() + code + (char) ('A' + random.nextInt(26));
                dto.setConsumerId(generateConsumerId());
                dto.setConsumerAccountNo(consumerCode);

                Consumer consumer = mapper.map(dto, Consumer.class);

                // Fetch Section from DB
                Section section = sectionRepository.findById(dto.getSection())
                        .orElseThrow(() -> new RuntimeException("Section not found: " + dto.getSection()));
                consumer.setSection(section);

                // Fetch Transformer from DB
                Transformer transformer = transformerRepository.findById(dto.getTransformer())
                        .orElseThrow(() -> new RuntimeException("Transformer not found: " + dto.getTransformer()));
                consumer.setTransformer(transformer);

                // Save consumer to DB
                consumerRepository.save(consumer);
            }

            return "Consumer data uploaded successfully.";
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload data: " + e.getMessage());
        }
    }

    private String generateConsumerId() {
        String id;
        do {
            id = String.valueOf(1000000000L + (long) (random.nextDouble() * 9000000000L));
        } while (consumerRepository.existsById(id));
        return id;
    }

}
