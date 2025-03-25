package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.utils.MyPage;

import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
    MyPage<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
}
