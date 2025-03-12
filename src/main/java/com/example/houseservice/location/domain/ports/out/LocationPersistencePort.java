package com.example.houseservice.location.domain.ports.out;

import com.example.houseservice.location.domain.model.LocationModel;

public interface LocationPersistencePort {
    void saveLocation(LocationModel locationModel);
}
