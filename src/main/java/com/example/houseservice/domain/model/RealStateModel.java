package com.example.houseservice.domain.model;

import java.time.LocalDate;

public class RealStateModel {
    private Long id;
    private String name;
    private String description;
    private Integer rooms;
    private Integer bathrooms;
    private Float price;
    private LocationModel location;
    private CategoryModel category;
    private LocalDate publishDate;
    private String status;

    public RealStateModel(Long id, String name, String description, Integer rooms, Integer bathrooms, Float price, LocationModel location, CategoryModel category, LocalDate publishDate, String status) {
        this.id = id;
        setName(name);
        setDescription(description);
        setRooms(rooms);
        setBathrooms(bathrooms);
        setPrice(price);
        setLocation(location);
        setCategory(category);
        setPublishDate(publishDate);
        setStatus(status);
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

    public Integer getRooms() {
        return rooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Float getPrice() {
        return price;
    }

    public LocationModel getLocation() {
        return location;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
