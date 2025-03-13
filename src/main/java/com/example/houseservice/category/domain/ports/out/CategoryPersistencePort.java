package com.example.houseservice.category.domain.ports.out;

import com.example.houseservice.category.domain.model.CategoryModel;
import com.example.houseservice.category.domain.utils.Page;

import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
    Page<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
}
