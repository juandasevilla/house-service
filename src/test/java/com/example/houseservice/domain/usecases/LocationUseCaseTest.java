package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.model.DepartmentModel;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;

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

}