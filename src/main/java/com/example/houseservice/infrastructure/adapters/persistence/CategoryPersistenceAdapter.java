package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.domain.utils.MyPage;
import com.example.houseservice.infrastructure.entities.CategoryEntity;
import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.infrastructure.mappers.CategoryEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CategoryRepository;
import com.example.houseservice.infrastructure.repositories.mysql.RealStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final RealStateRepository realStateRepository;

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public List <CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return categoryEntityMapper.entityListToModelList(categoryRepository.findAll(pagination).getContent());
    }


    @Override
    public MyPage<CategoryModel> getCategoriesPage(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }
        Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pagination);
        List<CategoryModel> categoryModels = categoryEntityMapper.entityListToModelList(categoryEntityPage.getContent());
        long totalObjects = categoryRepository.count();
        System.out.println("conteng: " + categoryModels);
        System.out.println("Página solicitada: " + page);
        System.out.println("Tamaño solicitado: " + size);
        System.out.println("Total de elementos: " + totalObjects);
        System.out.println("Elementos en esta página: " + categoryModels.size());
        return new MyPage<>(categoryModels, page, size, orderAsc, totalObjects);
    }

    @Override
    public Optional<CategoryModel> findById(Long id) {
        return categoryRepository.findById(id).map(categoryEntityMapper::entityToModel);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean hasReferences(Long id) {
        return realStateRepository.existsByCategoryId(id);
    }
}
