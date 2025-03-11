package com.example.houseservice.department.infrastructure.exceptionshandler;

public class ExceptionConstants {
    private ExceptionConstants() {}

    public static final String NAME_MAX_SIZE_MESSAGE = "The name of the department can not exceed 50 characters";
    public static final String DESCRIPTION_MAX_SIZE_MESSAGE = "The description of the department can not exceed 90 characters";
    public static final String DEPARTMENT_EXISTS_EXCEPTION = "The department already exists";
    public static final String NULL_OR_SPACE_EXCEPTION = "The name and description of the department can not be null or empty";
}
