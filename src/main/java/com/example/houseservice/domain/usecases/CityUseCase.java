package com.example.houseservice.domain.usecases;


import com.example.houseservice.domain.exceptions.ObjectAlreadyExistsException;
import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.ports.in.CityServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;

import java.util.List;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
    }

    @Override
    public void SaveCity(CityModel cityModel) {
        CityModel city = cityPersistencePort.getCityByName(cityModel.getName());
        if (city != null) {
            throw new ObjectAlreadyExistsException();
        }
        cityPersistencePort.saveCity(cityModel);
    }

    @Override
    public List<CityModel> getCities(Integer page, Integer size, boolean orderAsc) {
        return cityPersistencePort.getCities(page, size, orderAsc);
    }
}
