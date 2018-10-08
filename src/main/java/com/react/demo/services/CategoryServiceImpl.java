package com.react.demo.services;

import com.react.demo.api.dto.CategoryDto;
import com.react.demo.api.mappers.CategoryMapper;
import com.react.demo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public Set<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toSet());
    }
}
