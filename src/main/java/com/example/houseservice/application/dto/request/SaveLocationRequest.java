package com.example.houseservice.application.dto.request;

public record SaveLocationRequest(String name, String description, Long cityId) {

    public Long getCityId() {
        return cityId;
    }

}
