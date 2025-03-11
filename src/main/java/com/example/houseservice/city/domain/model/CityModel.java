package com.example.houseservice.city.domain.model;


import com.example.houseservice.city.domain.exceptions.CityNameMaxSizeExceededException;
import com.example.houseservice.city.domain.exceptions.CityNullOrSpaceException;
import com.example.houseservice.city.domain.exceptions.DescriptionMaxSizeExceededException;


public class CityModel {
    private Long id;
    private String name;
    private String description;

    public CityModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new CityNameMaxSizeExceededException();
        }
        if (description.length() > 120) {
            throw new DescriptionMaxSizeExceededException();
        }
        if (name == null || name.trim().isEmpty()){
            throw new CityNullOrSpaceException();
        }

        if (description == null || description.trim().isEmpty()){
            throw new CityNullOrSpaceException();
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name.length() > 50) {
            throw new CityNameMaxSizeExceededException();
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.length() > 120) {
            throw new DescriptionMaxSizeExceededException();
        }
        this.description = description;
    }
}
