package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveLocationRequest;
import com.example.houseservice.application.dto.response.SaveLocationResponse;

public interface LocationService {
    SaveLocationResponse save(SaveLocationRequest request);
}
