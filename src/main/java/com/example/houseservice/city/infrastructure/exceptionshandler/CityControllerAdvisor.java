package com.example.houseservice.city.infrastructure.exceptionshandler;

import com.example.houseservice.city.domain.exceptions.CityAlreadyExistsException;
import com.example.houseservice.city.domain.exceptions.CityNameMaxSizeExceededException;
import com.example.houseservice.city.domain.exceptions.CityNullOrSpaceException;
import com.example.houseservice.city.domain.exceptions.DescriptionMaxSizeExceededException;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@Component("cityControllerAdvisor")
public class CityControllerAdvisor {
    @ExceptionHandler(CityAlreadyExistsException.class)
    public ResponseEntity<CityExceptionResponse> handleCityAlreadyExistsException(CityAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.CITY_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(CityNullOrSpaceException.class)
    public ResponseEntity<CityExceptionResponse> handleNullOrSpaceException(CityNullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(CityNameMaxSizeExceededException.class)
    public ResponseEntity<CityExceptionResponse> handleNameMaxSizeExceededException(CityNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxSizeExceededException.class)
    public ResponseEntity<CityExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_DESCRIPTION_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }
}
