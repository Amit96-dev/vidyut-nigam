package com.sm.vidyut_nigam.service.system_configuration.category;

import java.util.List;

import com.sm.vidyut_nigam.dto.system_configuration.category.CategoryDTO;
import com.sm.vidyut_nigam.dto.system_configuration.category.CategoryResponseDTO;

public interface CategoryService {

    String createCategory(CategoryDTO categoryDTO);

    List<CategoryResponseDTO> showAllCategories();
}
