package com.example.houseservice.city.domain.ports.out;

import com.example.houseservice.city.domain.model.CityModel;

import java.util.List;

public interface CityPersistencePort {
    void saveCity(CityModel cityModel);
    CityModel getCityByName(String cityName);
    List <CityModel> getCities(Integer page, Integer size, boolean orderAsc);
}
