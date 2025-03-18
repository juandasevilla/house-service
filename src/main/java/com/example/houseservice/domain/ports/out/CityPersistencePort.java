package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.CityModel;

import java.util.List;
import java.util.Optional;

public interface CityPersistencePort {
    void saveCity(CityModel cityModel);
    CityModel getCityByName(String cityName);
    List <CityModel> getCities(Integer page, Integer size, boolean orderAsc);
    Optional <CityModel> findById(Long id);
}
