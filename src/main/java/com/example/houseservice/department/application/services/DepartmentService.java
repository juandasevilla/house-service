package com.example.houseservice.department.application.services;

import com.example.houseservice.department.application.dto.request.SaveDepartmentRequest;
import com.example.houseservice.department.application.dto.response.DepartmentResponse;
import com.example.houseservice.department.application.dto.response.SaveDepartmentResponse;

import java.util.List;

public interface DepartmentService {
    SaveDepartmentResponse save(SaveDepartmentRequest request);
    List <DepartmentResponse> getDepartments(Integer page, Integer size, boolean orderAsc);
}
