package com.example.houseservice.domain.model;

import com.example.houseservice.domain.exceptions.CityIsRequiredException;
import com.example.houseservice.domain.exceptions.DepartmentIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationNullOrSpaceException;

public class LocationModel {
    private Long id;
    private CityModel city;
    private String name;
    private String description;

    public LocationModel(Long id, CityModel city, String name, String description) {
        if (name == null || name.trim().isEmpty()){
            throw new LocationNullOrSpaceException();
        }

        this.id = id;
        this.city = city;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public CityModel getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(CityModel cityModel) {
        this.city = cityModel;
    }

}
