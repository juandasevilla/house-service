package com.example.houseservice.domain.ports.in;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.utils.Page;

import java.util.List;

public interface CategoryServicePort {

    void saveCategory(CategoryModel categoryModel);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
    Page<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc);
}
