package com.example.houseservice.category.domain.ports.in;

import com.example.houseservice.category.domain.model.CategoryModel;
import com.example.houseservice.category.domain.utils.Page;

import java.util.List;

public interface CategoryServicePort {

    void saveCategory(CategoryModel categoryModel);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
    Page<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
}
