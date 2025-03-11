package com.sm.vidyut_nigam.service.system_configuration.category.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sm.vidyut_nigam.dto.system_configuration.category.CategoryDTO;
import com.sm.vidyut_nigam.dto.system_configuration.category.CategoryResponseDTO;
import com.sm.vidyut_nigam.entity.system_configuration.Category;
import com.sm.vidyut_nigam.repository.system_configuration.CategoryRepository;
import com.sm.vidyut_nigam.service.system_configuration.category.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public String createCategory(CategoryDTO categoryDTO) {
        try {
            Category category = new Category();
            BeanUtils.copyProperties(categoryDTO, category);
            category.setCategoryStatus(true);
            categoryRepository.save(category);
            return "Category created successfully";
        } catch (Exception e) {
            return "Error creating category: " + e.getMessage();
        }
    }

    @Override
    public List<CategoryResponseDTO> showAllCategories() {
        try {
            List<Category> categories = categoryRepository.findAll();
            List<CategoryResponseDTO> categoryResponseDTOs = categories.stream().map(category -> {
                CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
                BeanUtils.copyProperties(category, categoryResponseDTO);
                return categoryResponseDTO;
            }).toList();
            return categoryResponseDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch categories: " + e.getMessage(), e);
        }
    }

}
