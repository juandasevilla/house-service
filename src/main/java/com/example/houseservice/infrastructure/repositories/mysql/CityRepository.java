package com.example.houseservice.infrastructure.repositories.mysql;

import com.example.houseservice.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    Optional<CityEntity> findByName(String name);
    Page<CityEntity> findAll(Pageable pageable);
}
