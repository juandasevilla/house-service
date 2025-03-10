package com.example.houseservice.department.domain.ports.in;

import com.example.houseservice.department.domain.model.DepartmentModel;
import java.util.List;

public interface DepartmentServicePort {
    void saveDepartment(DepartmentModel departmentModel);
    List <DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);
}
