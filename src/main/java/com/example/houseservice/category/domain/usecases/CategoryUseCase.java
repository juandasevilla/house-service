package com.example.houseservice.category.domain.usecases;

import com.example.houseservice.category.domain.exceptions.CategoryAlreadyExistsException;
import com.example.houseservice.category.domain.model.CategoryModel;
import com.example.houseservice.category.domain.ports.in.CategoryServicePort;
import com.example.houseservice.category.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.category.domain.utils.Page;

import java.util.List;

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

    @Override
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }

    @Override
    public Page<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategoriesPage(page, size, orderAsc);
    }
}
