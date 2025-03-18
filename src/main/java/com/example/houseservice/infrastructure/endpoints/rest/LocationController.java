package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveLocationRequest;
import com.example.houseservice.application.dto.response.SaveLocationResponse;
import com.example.houseservice.application.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.houseservice.application.dto.response.LocationResponse;
import com.example.houseservice.domain.utils.MyPage;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<SaveLocationResponse> saveLocation(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(saveLocationRequest));
    }

    @GetMapping("/page")
    public ResponseEntity<MyPage<LocationResponse>> getLocationsPage(@RequestParam Integer page, @RequestParam Integer size,
                                                                       @RequestParam boolean orderAsc, @RequestParam String name) {
        return ResponseEntity.ok(locationService.getLocationsByName(page, size, orderAsc, name));
    }
}
