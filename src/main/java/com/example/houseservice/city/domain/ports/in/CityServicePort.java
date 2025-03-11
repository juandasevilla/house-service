package com.example.houseservice.city.domain.ports.in;

import com.example.houseservice.city.domain.model.CityModel;

import java.util.List;

public interface CityServicePort {
    void SaveCity(CityModel cityModel);
    List <CityModel> getCities(Integer page, Integer size, boolean orderAsc);
}
