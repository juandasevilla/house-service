package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.CategoryModel;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
}
