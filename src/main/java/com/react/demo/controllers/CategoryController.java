package com.react.demo.controllers;

import com.react.demo.api.dto.CategoryDto;
import com.react.demo.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Set<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
