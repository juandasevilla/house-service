package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CityIsRequiredException;
import com.example.houseservice.domain.exceptions.DepartmentIsRequiredException;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.in.LocationServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;

public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;
    private final CityPersistencePort cityPersistencePort;
    private final DepartmentPersistencePort departmentPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort, CityPersistencePort cityPersistencePort, DepartmentPersistencePort departmentPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
        this.cityPersistencePort = cityPersistencePort;
        this.departmentPersistencePort = departmentPersistencePort;
    }

    public void saveLocation(LocationModel locationModel) {
        if(!cityPersistencePort.findById(locationModel.getCity().getId()).isPresent()) {
            throw new CityIsRequiredException();
        }
        if (!departmentPersistencePort.findById(locationModel.getDepartment().getId()).isPresent()) {
            throw new DepartmentIsRequiredException();
        }
        locationPersistencePort.saveLocation(locationModel);
    }


}
