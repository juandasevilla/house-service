package com.example.houseservice.application.dto.response;

public record LocationResponse(Long id, String name, String description, CityResponse city) {
}
