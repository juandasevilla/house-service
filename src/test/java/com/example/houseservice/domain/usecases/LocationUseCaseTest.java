package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.model.DepartmentModel;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.utils.MyPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocationUseCaseTest {

    @Mock
    private LocationPersistencePort locationPersistencePort;

    @Mock
    private CityPersistencePort cityPersistencePort;

    @Mock
    private DepartmentPersistencePort departmentPersistencePort;

    @InjectMocks
    private LocationUseCase locationUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveLocation_shouldSaveLocation_whenCityAndDepartmentFound() {
        CityModel cityModel = new CityModel(1l, "City 1", "Description 1");
        DepartmentModel departmentModel = new DepartmentModel(1l, "Department 1", "Description 1");
        LocationModel locationModel = new LocationModel(1l, departmentModel, cityModel, "Location 1", "Description 1");

        when(cityPersistencePort.findById(1L)).thenReturn(Optional.of(cityModel));
        when(departmentPersistencePort.findById(1L)).thenReturn(Optional.of(departmentModel));

        locationUseCase.saveLocation(locationModel);
    }

    @Test
    void getLocationsByName_shouldReturnLocations_whenCalled() {
        int page = 0;
        int size = 10;
        boolean orderAsc = true;
        String name = "test";

        LocationModel location1 = new LocationModel(1L, null, null, "Location 1", "Description 1");
        LocationModel location2 = new LocationModel(2L, null, null, "Location 2", "Description 2");
        List<LocationModel> locations = Arrays.asList(location1, location2);
        MyPage<LocationModel> expectedPage = new MyPage<>(locations, page, size, orderAsc, locations.size());

        when(locationPersistencePort.getLocationsByName(page, size, orderAsc, name)).thenReturn(expectedPage);

        MyPage<LocationModel> result = locationUseCase.getLocationsByName(page, size, orderAsc, name);

        assertEquals(expectedPage, result);
    }

}