package com.example.houseservice.application.dto.request;

public record SaveLocationRequest(String name, String description, Long departmentId, Long cityId) {

    public Long getCityId() {
        return cityId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }
}
