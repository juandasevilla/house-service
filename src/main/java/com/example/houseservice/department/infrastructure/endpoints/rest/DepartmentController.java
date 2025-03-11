package com.example.houseservice.department.infrastructure.endpoints.rest;

import com.example.houseservice.department.application.dto.request.SaveDepartmentRequest;
import com.example.houseservice.department.application.dto.response.DepartmentResponse;
import com.example.houseservice.department.application.dto.response.SaveDepartmentResponse;
import com.example.houseservice.department.application.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<SaveDepartmentResponse> saveDepartment(@RequestBody SaveDepartmentRequest saveDepartmentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(saveDepartmentRequest));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(@RequestParam Integer page, @RequestParam Integer size,
                                                                      @RequestParam boolean orderAsc) {
        return ResponseEntity.ok(departmentService.getDepartments(page, size, orderAsc));
    }
}
