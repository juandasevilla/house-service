package com.example.houseservice.infrastructure.mappers;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
}
