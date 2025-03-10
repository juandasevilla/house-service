package com.example.houseservice.domain.model;

import com.example.houseservice.domain.exceptions.DescriptionMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.NameMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.NullOrSpaceException;
import com.example.houseservice.domain.utils.DomainConstants;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50) {
            throw new NameMaxSizeExceededException();
        }
        if (description.length() > 90) {
            throw new DescriptionMaxSizeExceededException();
        }
        if (name == null || name.trim().isEmpty()){
            throw new NullOrSpaceException();
        }

        if (description == null || description.trim().isEmpty()){
            throw new NullOrSpaceException();
        }
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name.length() > 50) {
            throw new NameMaxSizeExceededException();
        }
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public void setDescription(String description) {
        if (description.length() > 90) {
            throw new DescriptionMaxSizeExceededException();
        }
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }
}
