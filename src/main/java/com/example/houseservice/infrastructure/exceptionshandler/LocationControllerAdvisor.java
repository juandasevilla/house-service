package com.example.houseservice.infrastructure.exceptionshandler;

import com.example.houseservice.domain.exceptions.CityIsRequiredException;
import com.example.houseservice.domain.exceptions.DepartmentIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationAlreadyExistsException;
import com.example.houseservice.domain.exceptions.LocationNullOrSpaceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Component("locationControllerAdvisor")
public class LocationControllerAdvisor {
    @ExceptionHandler(CityIsRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleCityIsRequiredException(CityIsRequiredException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CITY_IS_REQUIRED, LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentIsRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentIsRequiredException(DepartmentIsRequiredException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_IS_REQUIRED, LocalDateTime.now()));
    }

    @ExceptionHandler(LocationNullOrSpaceException.class)
    public ResponseEntity<ExceptionResponse> handleLocationNullOrSpaceException(LocationNullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.LOCATION_NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(LocationAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleLocationAlreadyExistsException(LocationAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.LOCATION_ALREADY_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

}
