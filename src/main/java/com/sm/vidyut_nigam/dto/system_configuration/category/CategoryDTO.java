package com.sm.vidyut_nigam.dto.system_configuration.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank(message = "Category name cannot be empty")
    private String categoryName;
    @NotNull(message = "Category emergency credit cannot be null")
    private double categoryEmergencyCredit;
}
