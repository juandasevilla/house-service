package com.example.houseservice.location.application.services;

import com.example.houseservice.location.application.dto.request.SaveLocationRequest;

public interface LocationService {
    void saveLocation(SaveLocationRequest request);
}
