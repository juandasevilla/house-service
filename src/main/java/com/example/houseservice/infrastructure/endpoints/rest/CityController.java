package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveCityRequest;
import com.example.houseservice.application.dto.response.CityResponse;
import com.example.houseservice.application.dto.response.SaveCityResponse;
import com.example.houseservice.application.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<SaveCityResponse> saveCity(@RequestBody SaveCityRequest saveCityRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(saveCityRequest));
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities(@RequestParam Integer page, @RequestParam Integer size,
                                                           @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(cityService.getCities(page, size, orderAsc));
    }
}
