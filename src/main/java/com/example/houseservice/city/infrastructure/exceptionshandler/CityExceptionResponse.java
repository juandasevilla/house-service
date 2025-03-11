package com.example.houseservice.city.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record CityExceptionResponse(String message, LocalDateTime timestamp) {
}
