package com.example.houseservice.application.dto.request;

public record SaveCityRequest(String name, String description, Long departmentId) {

    public Long getDepartmentId() {
        return departmentId;
    }
}
