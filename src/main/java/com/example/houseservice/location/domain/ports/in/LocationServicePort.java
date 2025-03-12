package com.example.houseservice.location.domain.ports.in;


import com.example.houseservice.location.domain.model.LocationModel;

import java.util.List;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
}
