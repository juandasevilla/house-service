package com.example.houseservice.domain.ports.in;

import com.example.houseservice.domain.model.CategoryModel;

public interface CategoryServicePort {

    void saveCategory(CategoryModel categoryModel);
}
