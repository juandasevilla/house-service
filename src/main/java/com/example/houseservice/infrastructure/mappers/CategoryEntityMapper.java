package com.example.houseservice.infrastructure.mappers;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
