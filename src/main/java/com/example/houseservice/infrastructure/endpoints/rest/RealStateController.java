package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.SaveRealStateResponse;
import com.example.houseservice.application.services.RealStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.houseservice.application.dto.response.LocationResponse;
import com.example.houseservice.domain.utils.MyPage;

@RestController
@RequestMapping("/api/v1/real-state")
@RequiredArgsConstructor
public class RealStateController {
    private final RealStateService realStateService;

    @PostMapping
    public ResponseEntity<SaveRealStateResponse> saveRealState(@RequestBody SaveRealStateRequest saveRealStateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(realStateService.save(saveRealStateRequest));
    }
}
