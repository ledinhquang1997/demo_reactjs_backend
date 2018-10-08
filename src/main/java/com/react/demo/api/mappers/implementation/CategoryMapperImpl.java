package com.react.demo.api.mappers.implementation;

import com.react.demo.api.dto.CategoryDto;
import com.react.demo.api.dto.ProductDto;
import com.react.demo.api.mappers.CategoryMapper;
import com.react.demo.api.mappers.ProductMapper;
import com.react.demo.domains.Category;
import com.react.demo.domains.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    private final ProductMapper productMapper;

    public CategoryMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if(category==null) return null;
        else {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());
            categoryDto.setProducts(this.setProductToProductDtoSet(category.getProducts()));
            return categoryDto;
        }
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        return null;
    }

    private Set<ProductDto> setProductToProductDtoSet(Set<Product> products){
        if(products==null) return null;
        else
        {
            return products.stream().map(productMapper::productToProductDto).collect(Collectors.toSet());
        }
    }
}
