package com.react.demo.controllers;

import com.react.demo.api.dto.Create.CreateProductDto;
import com.react.demo.api.dto.ProductDto;
import com.react.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createNewProduct(@RequestBody CreateProductDto createProductDto){
        return productService.createNewProduct(createProductDto);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return;
    }

}
