package com.example.houseservice.commons_configuration.beans;

import com.example.houseservice.domain.ports.in.CategoryServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.usecases.CategoryUseCase;
import com.example.houseservice.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.example.houseservice.infrastructure.mappers.CategoryEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}
