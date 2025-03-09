package com.example.houseservice.infrastructure.exceptionshandler;

import com.example.houseservice.domain.exceptions.CategoryAlreadyExistsException;
import com.example.houseservice.domain.exceptions.DescriptionMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.NameMaxSizeExceededException;
import com.example.houseservice.domain.exceptions.NullOrSpaceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(NameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DESCRIPTION_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.CATEGORY_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(NullOrSpaceException.class)
    public ResponseEntity<ExceptionResponse> handleNullOrSpaceException(NullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }
}
