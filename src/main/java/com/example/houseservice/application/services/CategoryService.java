package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveCategoryRequest;
import com.example.houseservice.application.dto.response.CategoryResponse;
import com.example.houseservice.application.dto.response.SaveCategoryResponse;

import java.util.List;


public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
    List <CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
