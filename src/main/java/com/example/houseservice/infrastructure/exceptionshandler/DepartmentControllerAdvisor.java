package com.example.houseservice.infrastructure.exceptionshandler;


import com.example.houseservice.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@Component("departmentControllerAdvisor")
public class DepartmentControllerAdvisor {
    @ExceptionHandler(DepartmentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentNullOrSpaceException.class)
    public ResponseEntity<ExceptionResponse> handleNullOrSpaceException(DepartmentNullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentDescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DepartmentDescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_DESCRIPTION_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentNameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(DepartmentNameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }
}
