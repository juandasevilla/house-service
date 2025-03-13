package com.example.houseservice.category.application.services;

import com.example.houseservice.category.application.dto.request.SaveCategoryRequest;
import com.example.houseservice.category.application.dto.response.CategoryResponse;
import com.example.houseservice.category.application.dto.response.SaveCategoryResponse;
import com.example.houseservice.category.domain.utils.Page;

import java.util.List;


public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
    List <CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
    Page<CategoryResponse> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
}
