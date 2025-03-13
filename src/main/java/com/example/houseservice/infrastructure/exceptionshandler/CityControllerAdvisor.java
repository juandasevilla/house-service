package com.example.houseservice.infrastructure.exceptionshandler;

import com.example.houseservice.domain.exceptions.ObjectAlreadyExistsException;
import com.example.houseservice.domain.exceptions.ObjectNameMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.ObjectNullOrSpaceException;
import com.example.houseservice.domain.exceptions.ObjectDescriptionMaxSizeExceededException;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@Component("cityControllerAdvisor")
public class CityControllerAdvisor {
    @ExceptionHandler(ObjectAlreadyExistsException.class)
    public ResponseEntity<CityExceptionResponse> handleCityAlreadyExistsException(ObjectAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.CITY_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(ObjectNullOrSpaceException.class)
    public ResponseEntity<CityExceptionResponse> handleNullOrSpaceException(ObjectNullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(ObjectNameMaxSizeExceededException.class)
    public ResponseEntity<CityExceptionResponse> handleNameMaxSizeExceededException(ObjectNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(ObjectDescriptionMaxSizeExceededException.class)
    public ResponseEntity<CityExceptionResponse> handleDescriptionMaxSizeExceededException(ObjectDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new CityExceptionResponse(CityExceptionConstants.City_DESCRIPTION_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }
}
