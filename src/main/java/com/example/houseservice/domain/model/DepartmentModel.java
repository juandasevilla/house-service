package com.example.houseservice.domain.model;

import com.example.houseservice.domain.exceptions.DepartmentDescriptionMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.DepartmentNameMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.DepartmentNullOrSpaceException;

public class DepartmentModel {
    private Long id;
    private String name;
    private String description;

    public DepartmentModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new DepartmentNameMaxSizeExceededException();
        }
        if (description.length() > 120) {
            throw new DepartmentDescriptionMaxSizeExceededException();
        }
        if (name == null || name.trim().isEmpty()){
            throw new DepartmentNullOrSpaceException();
        }

        if (description == null || description.trim().isEmpty()){
            throw new DepartmentNullOrSpaceException();
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
            throw new DepartmentNameMaxSizeExceededException();
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.length() > 120) {
            throw new DepartmentDescriptionMaxSizeExceededException();
        }
        this.description = description;
    }
}
