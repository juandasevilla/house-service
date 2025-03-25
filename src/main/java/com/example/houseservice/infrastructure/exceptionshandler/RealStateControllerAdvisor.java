package com.example.houseservice.infrastructure.exceptionshandler;

import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.exceptions.RealStatePublishDateException;
import com.example.houseservice.domain.exceptions.RealStateRequiredFieldException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
@Component("realStateControllerAdvisor")
public class RealStateControllerAdvisor {
    @ExceptionHandler(LocationIsRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleLocationIsRequiredException(LocationIsRequiredException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.LOCATION_IS_REQUIRED, LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryIsRequiredException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryIsRequiredException(CategoryIsRequiredException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_IS_REQUIRED, LocalDateTime.now()));
    }

    @ExceptionHandler(RealStatePublishDateException.class)
    public ResponseEntity<ExceptionResponse> handleRealStatePublishDateException(RealStatePublishDateException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.REAL_STATE_PUBLISH_DATE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(RealStateRequiredFieldException.class)
    public ResponseEntity<ExceptionResponse> handleRealStateRequiredFieldException(RealStateRequiredFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.REAL_STATE_REQUIRED_FIELD_EXCEPTION, LocalDateTime.now()));
    }

}
