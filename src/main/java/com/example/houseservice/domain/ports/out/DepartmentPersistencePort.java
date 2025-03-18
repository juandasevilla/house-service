package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.DepartmentModel;
import java.util.List;
import java.util.Optional;

public interface DepartmentPersistencePort {
    void saveDepartment(DepartmentModel departmentModel);
    DepartmentModel getDepartmentByName(String departmentName);
    List <DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);
    Optional <DepartmentModel> findById(Long id);
}
