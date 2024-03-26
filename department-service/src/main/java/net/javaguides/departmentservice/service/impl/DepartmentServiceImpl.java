package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.dto.DepartmentWithoutIdDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto store(DepartmentWithoutIdDto departmentDto) {
        // Convert departmentDto to department jpa entity
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setCode(departmentDto.getCode());

        Department saved = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto findByCode(String code) {
        Department department = departmentRepository.findByCode(code);

        return new DepartmentDto(
                department.getId(),
                department.getCode(),
                department.getDescription(),
                department.getName()
        );
    }
}