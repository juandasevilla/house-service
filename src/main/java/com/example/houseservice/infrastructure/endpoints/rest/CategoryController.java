package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveCategoryRequest;
import com.example.houseservice.application.dto.response.CategoryResponse;
import com.example.houseservice.application.dto.response.SaveCategoryResponse;
import com.example.houseservice.application.services.CategoryService;
import com.example.houseservice.domain.utils.Page;
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

    @GetMapping("/page")
    public ResponseEntity<Page<CategoryResponse>> getCategoriesPage(@RequestParam Integer page, @RequestParam Integer size,
                                                                    @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategoriesPage(page, size, orderAsc));
    }

}
