package com.example.houseservice.location.domain.model;

public class LocationModel {
    private Long id;
    private Long departmentId;
    private Long cityId;
    private String name;
    private String description;

    public LocationModel(Long id, Long departmentId, Long cityId, String name, String description) {
        this.id = id;
        this.departmentId = departmentId;
        this.cityId = cityId;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long getCityId() {
        return cityId;
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
}
