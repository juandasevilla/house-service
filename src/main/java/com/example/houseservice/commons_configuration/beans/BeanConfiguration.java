package com.example.houseservice.commons_configuration.beans;

import com.example.houseservice.category.domain.ports.in.CategoryServicePort;
import com.example.houseservice.category.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.category.domain.usecases.CategoryUseCase;
import com.example.houseservice.category.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.example.houseservice.category.infrastructure.mappers.CategoryEntityMapper;
import com.example.houseservice.category.infrastructure.repositories.mysql.CategoryRepository;
import com.example.houseservice.city.domain.ports.in.CityServicePort;
import com.example.houseservice.city.domain.ports.out.CityPersistencePort;
import com.example.houseservice.city.domain.usecases.CityUseCase;
import com.example.houseservice.city.infrastructure.adapters.persistence.CityPersistenceAdapter;
import com.example.houseservice.city.infrastructure.mappers.CityEntityMapper;
import com.example.houseservice.city.infrastructure.repositories.mysql.CityRepository;
import com.example.houseservice.department.domain.ports.in.DepartmentServicePort;
import com.example.houseservice.department.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.department.domain.usecases.DepartmentUseCase;
import com.example.houseservice.department.infrastructure.adapters.persistence.DepartmentPersistenceAdapter;
import com.example.houseservice.department.infrastructure.mappers.DepartmentEntityMapper;
import com.example.houseservice.department.infrastructure.repositories.mysql.DepartmentRepository;
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
}
