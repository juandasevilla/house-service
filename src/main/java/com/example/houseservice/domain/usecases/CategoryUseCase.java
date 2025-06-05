package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryAlreadyExistsException;
import com.example.houseservice.domain.exceptions.CategoryHasReferencesException;
import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.ports.in.CategoryServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.utils.MyPage;

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
    public MyPage<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategoriesPage(page, size, orderAsc);
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryPersistencePort.findById(id).isEmpty()) {
                throw new CategoryIsRequiredException();
        }
        if (categoryPersistencePort.hasReferences(id)) {
            throw new CategoryHasReferencesException();
        }
        categoryPersistencePort.deleteCategory(id);
    }
}
