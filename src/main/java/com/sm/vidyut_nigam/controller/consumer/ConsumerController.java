package com.sm.vidyut_nigam.controller.consumer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;
import com.sm.vidyut_nigam.dto.consumer.ConsumerResponseDTO;
import com.sm.vidyut_nigam.service.consumer.ConsumerService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping
    public ResponseEntity<?> createConsumer(@RequestBody ConsumerRequestDTO consumerRequestDTO) {
        try {
            String consumer = consumerService.createConsumer(consumerRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(consumer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/section/{sectionCode}")
    public ResponseEntity<?> getConsumerBySectionCode(@PathVariable int sectionCode,@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    @RequestParam(name = "size", required = false, defaultValue = "500") int size,
    @RequestParam(name = "sortBy", required = false, defaultValue = "sectionCode") String sortBy,
    @RequestParam(name = "sortDirection", required = false, defaultValue = "ASC") String sortDirection) {
        try {
            System.out.println("***********sectionCode: " + sectionCode);
            Page<ConsumerResponseDTO> consumerList = consumerService.getConsumerBySectionCode(sectionCode,page, size, sortBy, sortDirection);
            System.out.println(consumerList);
            return ResponseEntity.ok(consumerList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/transformer/{transformerCode}")
    public ResponseEntity<List<ConsumerResponseDTO>> getConsumerByTransformerCode(@PathVariable int transformerCode) {
        try {
            List<ConsumerResponseDTO> consumerList = consumerService.getConsumerByTransformerCode(transformerCode);
            System.out.println(consumerList);
            return ResponseEntity.ok(consumerList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadConsumers(@RequestParam("file") MultipartFile file) {
        try {
            String message = consumerService.uploadConsumers(file);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to upload data: " + e.getMessage());
        }
    }
}
