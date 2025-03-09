package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.infrastructure.mappers.CategoryEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }
}
