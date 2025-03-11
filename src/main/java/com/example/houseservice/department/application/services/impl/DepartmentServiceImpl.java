package com.example.houseservice.department.application.services.impl;

import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.department.application.dto.request.SaveDepartmentRequest;
import com.example.houseservice.department.application.dto.response.DepartmentResponse;
import com.example.houseservice.department.application.dto.response.SaveDepartmentResponse;
import com.example.houseservice.department.application.mappers.DepartmentDtoMapper;
import com.example.houseservice.department.application.services.DepartmentService;
import com.example.houseservice.department.domain.ports.in.DepartmentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentServicePort departmentServicePort;
    private final DepartmentDtoMapper departmentDtoMapper;

    @Override
    public SaveDepartmentResponse save(SaveDepartmentRequest request) {
        departmentServicePort.saveDepartment(departmentDtoMapper.requestToModel(request));
        return new SaveDepartmentResponse(Constants.SAVE_DEPARTMENT_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public List<DepartmentResponse> getDepartments(Integer page, Integer size, boolean orderAsc) {
        return departmentDtoMapper.modelListToResponseList(departmentServicePort.getDepartments(page, size, orderAsc));
    }
}
