package com.example.houseservice.department.domain.ports.out;

import com.example.houseservice.department.domain.model.DepartmentModel;
import java.util.List;

public interface DepartmentPersistencePort {
    void saveDepartment(DepartmentModel departmentModel);
    DepartmentModel getDepartmentByName(String departmentName);
    List <DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);
}
