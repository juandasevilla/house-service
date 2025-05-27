package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CityIsRequiredException;
import com.example.houseservice.domain.exceptions.DepartmentIsRequiredException;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.in.LocationServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.utils.MyPage;

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
        locationPersistencePort.saveLocation(locationModel);
    }

    public MyPage<LocationModel> getLocationsByName(int page, int size, boolean orderAsc, String name) {
        return locationPersistencePort.getLocationsByName(page, size, orderAsc, name);
    }

}
