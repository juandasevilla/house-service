package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryAlreadyExistsException;
import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.ports.in.CategoryServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.saveCategory(categoryModel);
    }
}
