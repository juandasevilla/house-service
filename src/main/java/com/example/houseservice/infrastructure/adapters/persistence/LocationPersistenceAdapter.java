package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.infrastructure.mappers.LocationEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CityRepository;
import com.example.houseservice.infrastructure.repositories.mysql.DepartmentRepository;
import com.example.houseservice.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;
    private final DepartmentRepository departmentRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void saveLocation(LocationModel locationModel) {
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }
}
