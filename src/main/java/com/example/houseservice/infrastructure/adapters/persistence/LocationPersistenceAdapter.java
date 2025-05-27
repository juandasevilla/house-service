package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.application.services.LocationService;
import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.utils.MyPage;
import com.example.houseservice.infrastructure.entities.LocationEntity;
import com.example.houseservice.infrastructure.mappers.LocationEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CityRepository;
import com.example.houseservice.infrastructure.repositories.mysql.DepartmentRepository;
import com.example.houseservice.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

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

    @Override
    public MyPage<LocationModel> getLocationsByName(int page, int size, boolean orderAsc, String name) {
        Pageable pagination;
        if (orderAsc) {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        } else {
            pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        }
        Page<LocationEntity> locationEntities = locationRepository.findByCityNameContainingIgnoreCaseOrCityDepartmentNameContainingIgnoreCase(name, name, pagination);
        List<LocationModel> locationModels = locationEntityMapper.entityListToModelList(locationEntities.getContent());
        long totalObjects = locationRepository.count();
        return new MyPage<>(locationModels, page, size, orderAsc, totalObjects);
    }

    @Override
    public Optional<LocationModel> findById(Long id) {
        return locationRepository.findById(id).map(locationEntityMapper::entityToModel);
    }

    @Override
    public LocationModel findByNameAndCityId(String name, Long cityId) {
        return locationRepository.findByNameIgnoreCaseAndCityId(name, cityId)
                .map(locationEntityMapper::entityToModel)
                .orElse(null); // Devuelve null si no encuentra la ubicación
    }
}
