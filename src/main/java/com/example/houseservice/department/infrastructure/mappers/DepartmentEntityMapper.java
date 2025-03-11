package com.example.houseservice.department.infrastructure.mappers;

import com.example.houseservice.department.domain.model.DepartmentModel;
import com.example.houseservice.department.infrastructure.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {
    DepartmentEntity modelToEntity(DepartmentModel departmentModel);
    DepartmentModel entityToModel(DepartmentEntity departmentEntity);
    List<DepartmentModel> entityListToModelList(List<DepartmentEntity> departments);
}
