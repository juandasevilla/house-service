package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveLocationRequest;
import com.example.houseservice.application.dto.response.LocationResponse;
import com.example.houseservice.application.dto.response.SaveLocationResponse;
import com.example.houseservice.domain.utils.MyPage;

public interface LocationService {
    SaveLocationResponse save(SaveLocationRequest request);
    MyPage<LocationResponse> getLocationsByName(Integer page, Integer size, boolean orderAsc, String name);
}
