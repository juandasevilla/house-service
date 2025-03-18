package com.example.houseservice.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record CityExceptionResponse(String message, LocalDateTime timestamp) {
}
