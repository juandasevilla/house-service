package com.example.houseservice.domain.model;


import com.example.houseservice.domain.exceptions.ObjectNameMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.ObjectNullOrSpaceException;
import com.example.houseservice.domain.exceptions.ObjectDescriptionMaxSizeExceededException;


public class CityModel {
    private Long id;
    private String name;
    private String description;

    public CityModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new ObjectNameMaxSizeExceededException();
        }
        if (description.length() > 120) {
            throw new ObjectDescriptionMaxSizeExceededException();
        }
        if (name == null || name.trim().isEmpty()){
            throw new ObjectNullOrSpaceException();
        }

        if (description == null || description.trim().isEmpty()){
            throw new ObjectNullOrSpaceException();
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
            throw new ObjectNameMaxSizeExceededException();
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.length() > 120) {
            throw new ObjectDescriptionMaxSizeExceededException();
        }
        this.description = description;
    }
}
