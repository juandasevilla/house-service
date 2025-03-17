package com.example.houseservice.domain.ports.in;


import com.example.houseservice.domain.model.LocationModel;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
}
