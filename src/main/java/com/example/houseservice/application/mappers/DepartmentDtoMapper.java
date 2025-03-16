package com.example.houseservice.application.mappers;

import com.example.houseservice.application.dto.request.SaveDepartmentRequest;
import com.example.houseservice.application.dto.response.DepartmentResponse;
import com.example.houseservice.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentDtoMapper {
    DepartmentModel requestToModel(SaveDepartmentRequest saveDepartmentRequest);
    DepartmentResponse modelToResponse(DepartmentModel departmentModel);
    List<DepartmentResponse> modelListToResponseList(List<DepartmentModel> departments);
}
