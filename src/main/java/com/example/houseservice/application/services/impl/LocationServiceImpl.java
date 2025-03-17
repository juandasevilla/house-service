package com.example.houseservice.application.services.impl;

import com.example.houseservice.application.dto.request.SaveLocationRequest;
import com.example.houseservice.application.dto.response.SaveLocationResponse;
import com.example.houseservice.application.mappers.LocationDtoMapper;
import com.example.houseservice.application.services.LocationService;
import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.model.DepartmentModel;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.in.LocationServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;
    private final CityPersistencePort cityPersistencePort;
    private final DepartmentPersistencePort departmentPersistencePort;

    @Override
    public SaveLocationResponse save(SaveLocationRequest request) {
        LocationModel locationModel = locationDtoMapper.requestToModel(request);
        CityModel cityModel = cityPersistencePort.findById(request.getCityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found"));
        locationModel.setCity(cityModel);
        DepartmentModel departmentModel = departmentPersistencePort.findById(request.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));
        locationModel.setDepartment(departmentModel);
        locationServicePort.saveLocation(locationModel);
        return new SaveLocationResponse(Constants.SAVE_LOCATION_RESPONSE_MESSAGE, LocalDateTime.now());
    }
}
