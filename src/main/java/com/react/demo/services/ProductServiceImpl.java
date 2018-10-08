package com.react.demo.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.react.demo.api.dto.Create.CreateProductDto;
import com.react.demo.api.dto.ProductDto;
import com.react.demo.api.mappers.ProductMapper;
import com.react.demo.domains.Category;
import com.react.demo.domains.Product;
import com.react.demo.repositories.CategoryRepository;
import com.react.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto createNewProduct(CreateProductDto createProductDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(createProductDto.getCategoryId());
        if(optionalCategory.isPresent()){
            Category category= optionalCategory.get();

            Product product= new Product();
            product.setName(createProductDto.getName());
            product.setPrice(createProductDto.getPrice());
            product.setDescription(createProductDto.getDescription());
            product.setPrice(createProductDto.getPrice());
            product.setImage(createProductDto.getImage());

            product.setCategory(category);

            Product savedProduct = productRepository.save(product);

            category.getProducts().add(product);
            categoryRepository.save(category);

            return productMapper.productToProductDto(savedProduct);
        }
        else{
            throw new RuntimeException("Category Not found");
        }
    }

    @Override
    public void deleteProduct(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Category category = productOptional.get().getCategory();
            categoryRepository.save(category.removeProduct(productOptional.get()));
            productRepository.delete(productOptional.get());
        }
        else{
            throw new RuntimeException("Product not found");
        }

    }
}
