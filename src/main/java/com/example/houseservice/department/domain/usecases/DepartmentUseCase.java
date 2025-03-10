package com.example.houseservice.department.domain.usecases;

import com.example.houseservice.department.domain.exceptions.DepartmentAlreadyExistsException;
import com.example.houseservice.department.domain.model.DepartmentModel;
import com.example.houseservice.department.domain.ports.in.DepartmentServicePort;
import com.example.houseservice.department.domain.ports.out.DepartmentPersistencePort;
import java.util.List;

public class DepartmentUseCase implements DepartmentServicePort {
    private final DepartmentPersistencePort departmentPersistencePort;

    public DepartmentUseCase(DepartmentPersistencePort departmentPersistencePort) {
        this.departmentPersistencePort = departmentPersistencePort;
    }

    @Override
    public void saveDepartment(DepartmentModel departmentModel) {
        DepartmentModel department = departmentPersistencePort.getDepartmentByName(departmentModel.getName());
        if (department != null) {
            throw new DepartmentAlreadyExistsException();
        }
        departmentPersistencePort.saveDepartment(departmentModel);
    }

    @Override
    public List<DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc) {
        return departmentPersistencePort.getDepartments(page, size, orderAsc);
    }
}
