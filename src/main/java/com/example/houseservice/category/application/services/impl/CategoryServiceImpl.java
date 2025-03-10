package com.example.houseservice.category.application.services.impl;

import com.example.houseservice.category.application.dto.request.SaveCategoryRequest;
import com.example.houseservice.category.application.dto.response.CategoryResponse;
import com.example.houseservice.category.application.dto.response.SaveCategoryResponse;
import com.example.houseservice.category.application.mappers.CategoryDtoMapper;
import com.example.houseservice.category.application.services.CategoryService;
import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.category.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;


    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.saveCategory(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE,LocalDateTime.now());
    }

    @Override
    public List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
    }
}
