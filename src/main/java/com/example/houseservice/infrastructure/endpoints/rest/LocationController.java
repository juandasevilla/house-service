package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveLocationRequest;
import com.example.houseservice.application.dto.response.SaveLocationResponse;
import com.example.houseservice.application.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<SaveLocationResponse> saveLocation(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(saveLocationRequest));
    }
}
