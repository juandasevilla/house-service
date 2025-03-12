package com.example.houseservice.location.domain.usecases;

import com.example.houseservice.location.domain.model.LocationModel;
import com.example.houseservice.location.domain.ports.out.LocationPersistencePort;

public class LocationUseCase {
    private final LocationPersistencePort locationPersistencePort;

    public LocationUseCase(LocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    public void saveLocation(LocationModel locationModel) {
        locationPersistencePort.saveLocation(locationModel);
    }


}
