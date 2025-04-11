package com.example.houseservice.domain.filters;

public class RealStateFilter {
    private String categoryName;
    private Integer bathrooms;
    private Integer rooms;
    private String locationName;
    private Float minPrice;
    private Float maxPrice;

    public RealStateFilter(String categoryName, Integer bathrooms, Integer rooms, String locationName, Float minPrice, Float maxPrice) {
        this.categoryName = categoryName;
        this.bathrooms = bathrooms;
        this.rooms = rooms;
        this.locationName = locationName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }
}


