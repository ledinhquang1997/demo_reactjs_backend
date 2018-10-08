package com.react.demo.api.mappers;

import com.react.demo.api.dto.ProductDto;
import com.react.demo.domains.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
}
