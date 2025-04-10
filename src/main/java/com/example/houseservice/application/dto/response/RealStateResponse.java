package com.example.houseservice.application.dto.response;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.model.LocationModel;

import java.time.LocalDate;

public record RealStateResponse(Long id, String name, String description, Integer rooms, Integer bathrooms, Float price, LocationModel location, CategoryModel category, LocalDate publishDate, String status) {
}
