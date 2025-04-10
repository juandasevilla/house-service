package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.exceptions.RealStateRequiredFieldException;
import com.example.houseservice.domain.model.*;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RealStateUseCaseTest {

    @Mock
    private RealStatePersistencePort realStatePersistencePort;

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @Mock
    private LocationPersistencePort locationPersistencePort;

    @InjectMocks
    private RealStateUseCase realStateUseCase;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveRealState_shouldSaveRealState_whenValid() {
        DepartmentModel department = new DepartmentModel(1L, "Department", "description");
        CityModel city = new CityModel(1L, "City", "description");
        LocationModel location = new LocationModel(1L, department, city, "Location", "Description");
        CategoryModel category = new CategoryModel(1L, "Category", "Description");
        RealStateModel realStateModel = new RealStateModel(1L, "RealState", "Description", 3, 2, 100000.0f, location, category, LocalDate.now(), "Available");

        when(categoryPersistencePort.findById(1L)).thenReturn(Optional.of(category));
        when(locationPersistencePort.findById(1L)).thenReturn(Optional.of(location));

        realStateUseCase.saveRealState(realStateModel);

        verify(realStatePersistencePort).saveRealState(realStateModel);
    }

    @Test
    void saveRealState_shouldThrowException_whenCategoryNotFound() {
        DepartmentModel department = new DepartmentModel(1L, "Department", "description");
        CityModel city = new CityModel(1L, "City", "description");
        LocationModel location = new LocationModel(1L, department, city, "Location", "Description");
        CategoryModel category = new CategoryModel(1L, "Category", "Description");
        RealStateModel realStateModel = new RealStateModel(1L, "RealState", "Description", 3, 2, 100000.0f, location, category, LocalDate.now(), "Available");

        when(categoryPersistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CategoryIsRequiredException.class, () -> realStateUseCase.saveRealState(realStateModel));
    }

    @Test
    void saveRealState_shouldThrowException_whenLocationNotFound() {
        DepartmentModel department = new DepartmentModel(1L, "Department", "description");
        CityModel city = new CityModel(1L, "City", "description");
        LocationModel location = new LocationModel(1L, department, city, "Location", "Description");
        CategoryModel category = new CategoryModel(1L, "Category", "Description");
        RealStateModel realStateModel = new RealStateModel(1L, "RealState", "Description", 3, 2, 100000.0f, location, category, LocalDate.now(), "Available");

        when(categoryPersistencePort.findById(1L)).thenReturn(Optional.of(category));
        when(locationPersistencePort.findById(1L)).thenReturn(Optional.empty());

        assertThrows(LocationIsRequiredException.class, () -> realStateUseCase.saveRealState(realStateModel));
    }

    @Test
    void saveRealState_shouldThrowException_whenRequiredFieldIsNull() {
        DepartmentModel department = new DepartmentModel(1L, "Department", "description");
        CityModel city = new CityModel(1L, "City", "description");
        LocationModel location = new LocationModel(1L, department, city, "Location", "Description");
        CategoryModel category = new CategoryModel(1L, "Category", "Description");
        RealStateModel realStateModel = new RealStateModel(1L, null, "Description", 3, 2, 100000.0f, location, category, LocalDate.now(), "Available");

        when(categoryPersistencePort.findById(1L)).thenReturn(Optional.of(category));
        when(locationPersistencePort.findById(1L)).thenReturn(Optional.of(location));

        assertThrows(RealStateRequiredFieldException.class, () -> realStateUseCase.saveRealState(realStateModel));
    }
}