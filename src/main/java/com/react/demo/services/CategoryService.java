package com.react.demo.services;

import com.react.demo.api.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {
    Set<CategoryDto> getAllCategories();
}
