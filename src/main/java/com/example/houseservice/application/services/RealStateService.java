package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.SaveRealStateResponse;

public interface RealStateService {
    SaveRealStateResponse save(SaveRealStateRequest request);
}
