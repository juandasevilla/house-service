package com.example.houseservice.infrastructure.repositories.mysql;

import com.example.houseservice.infrastructure.entities.RealStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealStateRepository extends JpaRepository<RealStateEntity, Long> {

}
