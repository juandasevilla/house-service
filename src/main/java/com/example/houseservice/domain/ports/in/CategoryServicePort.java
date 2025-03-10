package com.example.houseservice.domain.ports.in;

import com.example.houseservice.domain.model.CategoryModel;
import java.util.List;

public interface CategoryServicePort {

    void saveCategory(CategoryModel categoryModel);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
