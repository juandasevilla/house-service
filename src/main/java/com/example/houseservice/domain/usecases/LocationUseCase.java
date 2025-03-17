package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.ports.in.LocationServicePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;

public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    public void saveLocation(LocationModel locationModel) {
        locationPersistencePort.saveLocation(locationModel);
    }


}
