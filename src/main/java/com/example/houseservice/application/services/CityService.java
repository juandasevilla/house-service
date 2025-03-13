package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveCityRequest;
import com.example.houseservice.application.dto.response.CityResponse;
import com.example.houseservice.application.dto.response.SaveCityResponse;

import java.util.List;

public interface CityService {
    SaveCityResponse save(SaveCityRequest request);
    List <CityResponse> getCities(Integer page, Integer size, boolean orderAsc);
}
