package com.example.houseservice.city.application.services;

import com.example.houseservice.city.application.dto.request.SaveCityRequest;
import com.example.houseservice.city.application.dto.response.CityResponse;
import com.example.houseservice.city.application.dto.response.SaveCityResponse;

import java.util.List;

public interface CityService {
    SaveCityResponse save(SaveCityRequest request);
    List <CityResponse> getCities(Integer page, Integer size, boolean orderAsc);
}
