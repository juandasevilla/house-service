package com.example.houseservice.commons_configuration.beans;

import com.example.houseservice.domain.ports.in.*;
import com.example.houseservice.domain.ports.out.*;
import com.example.houseservice.domain.usecases.*;
import com.example.houseservice.infrastructure.adapters.persistence.*;
import com.example.houseservice.infrastructure.mappers.*;
import com.example.houseservice.infrastructure.repositories.mysql.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.beans.BeanProperty;

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
    private final RealStateRepository realStateRepository;
    private final RealStateEntityMapper realStateEntityMapper;

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
        return new CityUseCase(cityPersistencePort(), departmentPersistencePort());
    }

    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository,cityRepository,departmentRepository, locationEntityMapper);
    }

    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort(), cityPersistencePort(), departmentPersistencePort());
    }

    public RealStatePersistencePort realStatePersistencePort() {
        return new RealStatePersistenceAdapter(realStateRepository, realStateEntityMapper);
    }

    @Bean
    public RealStateServicePort realStateServicePort() {
        return new RealStateUseCase(realStatePersistencePort(), categoryPersistencePort(), locationPersistencePort());
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Cambia esto a la URL de tu frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }


}
