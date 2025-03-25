package com.example.houseservice.application.dto.request;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.model.LocationModel;

import java.time.LocalDate;

public record SaveRealStateRequest(String name, String description, Integer rooms, Integer bathrooms, Float price, Long locationId, Long categoryId, LocalDate publishDate, String status) {

        public Long getLocationId() {
            return locationId;
        }

        public Long getCategoryId() {
            return categoryId;
        }
}
