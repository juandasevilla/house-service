package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryAlreadyExistsException;
import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.utils.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategory() {
        CategoryModel categoryModel = new CategoryModel(1L, "Category 1", "Description 1");
        when(categoryPersistencePort.getCategoryByName(categoryModel.getName())).thenReturn(categoryModel);

        assertThrows(CategoryAlreadyExistsException.class, () -> categoryUseCase.saveCategory(categoryModel));
    }

    @Test
    void getCategoriesPage() {
        // Arrange
        int page = 0;
        int size = 5;
        boolean orderAsc = true;
        int totalObjects = 2;
        List<CategoryModel> categories = Arrays.asList(
                new CategoryModel(1L, "Category 1", "Description 1"),
                new CategoryModel(2L, "Category 2", "Description 2")
        );
        Page<CategoryModel> expectedPage = new Page<>(categories, page, size, orderAsc, totalObjects);

        when(categoryPersistencePort.getCategoriesPage(page, size, orderAsc)).thenReturn(expectedPage);

        // Act
        Page<CategoryModel> result = categoryUseCase.getCategoriesPage(page, size, orderAsc);

        // Assert
        assertEquals(expectedPage, result);
    }

}