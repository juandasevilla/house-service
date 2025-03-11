package com.example.houseservice.city.infrastructure.exceptionshandler;

public class CityExceptionConstants {
    private CityExceptionConstants() {}

    public static final String City_NAME_MAX_SIZE_MESSAGE = "The name of the city can not exceed 50 characters";
    public static final String CITY_EXISTS_EXCEPTION = "The city already exists";
    public static final String City_NULL_OR_SPACE_EXCEPTION = "The name of the city can not be null or empty";
    public static final String City_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the city can not exceed 90 characters";
}
