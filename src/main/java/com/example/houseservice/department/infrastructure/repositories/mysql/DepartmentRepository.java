package com.example.houseservice.department.infrastructure.repositories.mysql;

import com.example.houseservice.department.infrastructure.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByName(String name);
    Page<DepartmentEntity> findAll(Pageable pageable);
}
