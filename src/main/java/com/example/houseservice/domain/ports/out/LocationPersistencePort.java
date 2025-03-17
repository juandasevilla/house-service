package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.LocationModel;

public interface LocationPersistencePort {
    void saveLocation(LocationModel locationModel);
}
