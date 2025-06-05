package com.example.houseservice.application.dto.request;

import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.model.LocationModel;

import java.time.LocalDate;

public class SaveRealStateRequest{
    String name;
    String description;
    Integer rooms;
    Integer bathrooms;
    Float price;
    Long locationId;
    Long categoryId;
    LocalDate publishDate;
    String status;
    Long userId;

    public SaveRealStateRequest(String name, String description,
                                Integer rooms, Integer bathrooms, Float price,
                                Long locationId, Long categoryId,
                                LocalDate publishDate, String status, Long userId) {
        this.name = name;
        this.description = description;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.price = price;
        this.locationId = locationId;
        this.categoryId = categoryId;
        this.publishDate = publishDate;
        this.status = "PUBLICACION_PAUSADA";
        setUserId(userId);
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Integer getRooms() { return rooms; }
    public Integer getBathrooms() { return bathrooms; }
    public Float getPrice() { return price; }
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }
}
