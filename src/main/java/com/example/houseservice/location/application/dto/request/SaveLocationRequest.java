package com.example.houseservice.location.application.dto.request;

public record SaveLocationRequest(String name, String description, Long departmentId, Long cityId) {
}
