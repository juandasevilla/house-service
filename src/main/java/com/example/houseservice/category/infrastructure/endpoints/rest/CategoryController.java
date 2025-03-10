package com.example.houseservice.category.infrastructure.endpoints.rest;

import com.example.houseservice.category.application.dto.request.SaveCategoryRequest;
import com.example.houseservice.category.application.dto.response.CategoryResponse;
import com.example.houseservice.category.application.dto.response.SaveCategoryResponse;
import com.example.houseservice.category.application.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<SaveCategoryResponse> saveCategory(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam Integer page, @RequestParam Integer size,
                                                                   @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }

}
