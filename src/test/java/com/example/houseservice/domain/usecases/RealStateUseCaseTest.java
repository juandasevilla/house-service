package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.exceptions.RealStateRequiredFieldException;
import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.model.*;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;
import com.example.houseservice.domain.utils.MyPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

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
        RealStateModel realStateModel = new RealStateModel(1L, "casa prueba", "PRUEBA", null, 2, 100000.0f, location, category, LocalDate.now(), "Available");

        when(categoryPersistencePort.findById(1L)).thenReturn(Optional.of(category));
        when(locationPersistencePort.findById(1L)).thenReturn(Optional.of(location));

        RealStateRequiredFieldException exception = assertThrows(
                RealStateRequiredFieldException.class,
                () -> realStateUseCase.saveRealState(realStateModel)
        );
    }

    @Test
    void getRealStatesByFilter_shouldReturnFilteredResults() {
        // Arrange
        RealStateFilter filter = new RealStateFilter("Category1", 2, 3, "City1", 100000.0f, 200000.0f);
        int page = 0;
        int size = 10;
        boolean orderAsc = true;

        RealStateModel realState1 = new RealStateModel(1L, "RealState1", "Description1", 3, 2, 150000.0f, null, null, LocalDate.now().plusDays(15), "PUBLICADA");
        RealStateModel realState2 = new RealStateModel(2L, "RealState2", "Description2", 3, 2, 180000.0f, null, null, LocalDate.now().plusDays(15), "PUBLICADA");
        List<RealStateModel> realStates = Arrays.asList(realState1, realState2);

        MyPage<RealStateModel> expectedPage = new MyPage<>(realStates, page, size, orderAsc, 2L);

        when(realStatePersistencePort.getRealStatesByFilter(filter, page, size, orderAsc)).thenReturn(expectedPage);

        // Act
        MyPage<RealStateModel> result = realStateUseCase.getRealStatesByFilter(filter, page, size, orderAsc);

        // Assert
        assertEquals(expectedPage, result);
        verify(realStatePersistencePort).getRealStatesByFilter(filter, page, size, orderAsc);
    }
}