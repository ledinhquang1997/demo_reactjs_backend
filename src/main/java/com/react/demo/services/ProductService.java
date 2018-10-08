package com.react.demo.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.react.demo.api.dto.Create.CreateProductDto;
import com.react.demo.api.dto.ProductDto;
import com.react.demo.domains.Product;

import java.util.HashMap;

public interface ProductService {
    ProductDto createNewProduct(CreateProductDto createProductDto);
    void deleteProduct(int id);
}
