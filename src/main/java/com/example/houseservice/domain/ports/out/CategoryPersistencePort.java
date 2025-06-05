package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.utils.MyPage;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
    MyPage<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
    Optional<CategoryModel> findById(Long id);
    void deleteCategory(Long id);
    boolean hasReferences(Long id);
}
