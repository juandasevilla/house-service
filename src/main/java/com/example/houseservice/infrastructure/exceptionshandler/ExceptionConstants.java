package com.example.houseservice.infrastructure.exceptionshandler;

public final class ExceptionConstants {
    private ExceptionConstants() {}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the category can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the category can not exceed 90 characters";
    public static final String CATEGORY_EXISTS_EXCEPTION = "The category already exists";
    public static final String NULL_OR_SPACE_EXCEPTION = "The name and description of the category can not be null or empty";
    public static final String DEPARTMENT_NAME_MAX_SIZE_MESSAGE = "The name of the department can not exceed 50 characters";
    public static final String DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the department can not exceed 90 characters";
    public static final String DEPARTMENT_EXISTS_EXCEPTION = "The department already exists";
    public static final String DEPARTMENT_NULL_OR_SPACE_EXCEPTION = "The name and description of the department can not be null or empty";
    public static final String CITY_IS_REQUIRED = "City is required and must exists";
    public static final String DEPARTMENT_IS_REQUIRED = "Department is required and must exists";
    public static final String LOCATION_NULL_OR_SPACE_EXCEPTION = "The name of the location can not be null or empty";
    public static final String LOCATION_IS_REQUIRED = "Location is required and must exists";
    public static final String CATEGORY_IS_REQUIRED = "Category is required and must exists";
    public static final String REAL_STATE_PUBLISH_DATE_EXCEPTION = "The publish date of the real state can not be later 30 days from now";
    public static final String REAL_STATE_REQUIRED_FIELD_EXCEPTION = "The name, description, price, location, rooms, bathrooms, category and publish date of the real state can not be null or empty";
}
