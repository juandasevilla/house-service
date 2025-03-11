package com.example.houseservice.department.infrastructure.adapters.persistence;

import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.department.domain.model.DepartmentModel;
import com.example.houseservice.department.domain.ports.out.DepartmentPersistencePort;
import com.example.houseservice.department.infrastructure.mappers.DepartmentEntityMapper;
import com.example.houseservice.department.infrastructure.repositories.mysql.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistencePort {
    private final DepartmentRepository departmentRepository;
    private final DepartmentEntityMapper departmentEntityMapper;

    @Override
    public void saveDepartment(DepartmentModel departmentModel) {
        departmentRepository.save(departmentEntityMapper.modelToEntity(departmentModel));
    }

    @Override
    public DepartmentModel getDepartmentByName(String departmentName) {
        return departmentEntityMapper.entityToModel(departmentRepository.findByName(departmentName).orElse(null));
    }

    @Override
    public List <DepartmentModel> getDepartments(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return departmentEntityMapper.entityListToModelList(departmentRepository.findAll(pagination).getContent());
    }
}
