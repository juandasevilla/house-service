package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.CategoryModel;
import java.util.List;

public interface CategoryPersistencePort {
    void saveCategory(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
