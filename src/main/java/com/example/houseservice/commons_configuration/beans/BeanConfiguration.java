package com.example.houseservice.commons_configuration.beans;

import com.example.houseservice.domain.ports.in.CategoryServicePort;
import com.example.houseservice.domain.ports.in.LocationServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.usecases.CategoryUseCase;
import com.example.houseservice.domain.usecases.LocationUseCase;
import com.example.houseservice.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.example.houseservice.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.example.houseservice.infrastructure.mappers.CategoryEntityMapper;
import com.example.houseservice.infrastructure.mappers.LocationEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CategoryRepository;
import com.example.houseservice.domain.ports.in.CityServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.usecases.CityUseCase;
import com.example.houseservice.infrastructure.adapters.persistence.CityPersistenceAdapter;
import com.example.houseservice.infrastructure.mappers.CityEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CityRepository;
import com.example.houseservice.domain.ports.in.DepartmentServicePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.domain.usecases.DepartmentUseCase;
import com.example.houseservice.infrastructure.adapters.persistence.DepartmentPersistenceAdapter;
import com.example.houseservice.infrastructure.mappers.DepartmentEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.DepartmentRepository;
import com.example.houseservice.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;
    private final LocationEntityMapper locationEntityMapper;
    private final LocationRepository locationRepository;

    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    public DepartmentPersistencePort departmentPersistencePort() {
        return new DepartmentPersistenceAdapter(departmentRepository, departmentEntityMapper);
    }

    @Bean
    public DepartmentServicePort departmentServicePort() {
        return new DepartmentUseCase(departmentPersistencePort());
    }

    public CityPersistencePort cityPersistencePort() {
        return new CityPersistenceAdapter(cityRepository, cityEntityMapper);
    }

    @Bean
    public CityServicePort cityServicePort() {
        return new CityUseCase(cityPersistencePort());
    }

    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository,cityRepository,departmentRepository, locationEntityMapper);
    }

    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort(), cityPersistencePort(), departmentPersistencePort());
    }
}
