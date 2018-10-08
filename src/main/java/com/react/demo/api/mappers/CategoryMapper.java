package com.react.demo.api.mappers;

import com.react.demo.api.dto.CategoryDto;
import com.react.demo.domains.Category;

public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
