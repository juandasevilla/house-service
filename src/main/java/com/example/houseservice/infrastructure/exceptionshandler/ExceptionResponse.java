package com.example.houseservice.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timestamp) {
}
