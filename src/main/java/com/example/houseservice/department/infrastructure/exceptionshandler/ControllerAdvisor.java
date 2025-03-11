package com.example.houseservice.department.infrastructure.exceptionshandler;

import com.example.houseservice.department.domain.exceptions.DepartmentAlreadyExistsException;
import com.example.houseservice.department.domain.exceptions.DescriptionMaxSizeExceededException;
import com.example.houseservice.department.domain.exceptions.NameMaxSizeExceededException;
import com.example.houseservice.department.domain.exceptions.NullOrSpaceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@Component("departmentControllerAdvisor")
public class ControllerAdvisor {
    @ExceptionHandler(DepartmentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DEPARTMENT_EXISTS_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(NullOrSpaceException.class)
    public ResponseEntity<ExceptionResponse> handleNullOrSpaceException(NullOrSpaceException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NULL_OR_SPACE_EXCEPTION, LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.DESCRIPTION_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }

    @ExceptionHandler(NameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(ExceptionConstants.NAME_MAX_SIZE_MESSAGE, LocalDateTime.now()));
    }
}
