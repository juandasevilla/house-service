package com.example.houseservice.domain.usecases;


import com.example.houseservice.domain.exceptions.DepartmentIsRequiredException;
import com.example.houseservice.domain.exceptions.ObjectAlreadyExistsException;
import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.ports.in.CityServicePort;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.domain.ports.out.DepartmentPersistencePort;

import java.util.List;

public class CityUseCase implements CityServicePort {
    private final CityPersistencePort cityPersistencePort;
    private final DepartmentPersistencePort departmentPersistencePort;

    public CityUseCase(CityPersistencePort cityPersistencePort, DepartmentPersistencePort departmentPersistencePort) {
        this.cityPersistencePort = cityPersistencePort;
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void SaveCity(CityModel cityModel) {
        CityModel city = cityPersistencePort.getCityByName(cityModel.getName());
        if (city != null) {
            throw new ObjectAlreadyExistsException();
        }
        if (!departmentPersistencePort.findById(cityModel.getDepartment().getId()).isPresent()) {
            throw new DepartmentIsRequiredException();
        }
        cityPersistencePort.saveCity(cityModel);
    }

    @Override
    public List<CityModel> getCities(Integer page, Integer size, boolean orderAsc) {
        return cityPersistencePort.getCities(page, size, orderAsc);
    }
}
