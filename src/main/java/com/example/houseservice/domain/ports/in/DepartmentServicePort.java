package com.example.houseservice.domain.ports.in;

import com.example.houseservice.domain.model.DepartmentModel;
import java.util.List;

public interface DepartmentServicePort {
    void saveDepartment(DepartmentModel departmentModel);
    List <DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc);
}
