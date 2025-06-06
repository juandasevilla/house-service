package com.example.houseservice.infrastructure.endpoints.rest;

import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.RealStateResponse;
import com.example.houseservice.application.dto.response.SaveRealStateResponse;
import com.example.houseservice.application.services.RealStateService;
import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.model.RealStateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.houseservice.application.dto.response.LocationResponse;
import com.example.houseservice.domain.utils.MyPage;
import org.springframework.security.core.Authentication;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/real-state")
@RequiredArgsConstructor
public class RealStateController {
    private final RealStateService realStateService;

    @PostMapping
    public ResponseEntity<SaveRealStateResponse> saveRealState(@RequestBody SaveRealStateRequest saveRealStateRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // El ID de usuario está en los detalles de la autenticación
        Map<String, Object> details = (Map<String, Object>) authentication.getDetails();
        Long userId = (Long) details.get("userId");

        // Asignar el ID del usuario a la solicitud
        saveRealStateRequest.setUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(realStateService.save(saveRealStateRequest));
    }

    @GetMapping
    public ResponseEntity<MyPage<RealStateResponse>> getRealStatesByFilter(@RequestParam(required = false) String categoryName,
                                                                           @RequestParam(required = false) Integer bathrooms,
                                                                           @RequestParam(required = false) Integer rooms,
                                                                           @RequestParam(required = false) String locationName,
                                                                           @RequestParam(required = false) Float minPrice,
                                                                           @RequestParam(required = false) Float maxPrice,
                                                                           @RequestParam(defaultValue = "0") Integer page,
                                                                           @RequestParam(defaultValue = "10") Integer size,
                                                                           @RequestParam(defaultValue = "true") boolean orderAsc){

        RealStateFilter filter = new RealStateFilter(categoryName, bathrooms, rooms, locationName, minPrice, maxPrice);
        return ResponseEntity.ok(realStateService.getRealStatesByFilter(filter, page, size, orderAsc));
    }

    @GetMapping("/exists-real-state/{id}")
    public ResponseEntity<Boolean> existsRealStateById(@PathVariable Long id){
        return ResponseEntity.ok(realStateService.existsRealStateWithId(id));
    }


}
