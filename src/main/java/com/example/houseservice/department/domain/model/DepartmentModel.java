package com.example.houseservice.department.domain.model;

import com.example.houseservice.department.domain.exceptions.DescriptionMaxSizeExceededException;
import com.example.houseservice.department.domain.exceptions.NameMaxSizeExceededException;
import com.example.houseservice.department.domain.exceptions.NullOrSpaceException;

public class DepartmentModel {
    private Long id;
    private String name;
    private String description;

    public DepartmentModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new NameMaxSizeExceededException();
        }
        if (description.length() > 120) {
            throw new DescriptionMaxSizeExceededException();
        }
        if (name == null || name.trim().isEmpty()){
            throw new NullOrSpaceException();
        }

        if (description == null || description.trim().isEmpty()){
            throw new NullOrSpaceException();
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
            throw new NameMaxSizeExceededException();
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
