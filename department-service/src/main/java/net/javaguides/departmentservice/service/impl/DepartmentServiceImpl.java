package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.dto.DepartmentWithoutIdDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mappers.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto store(DepartmentWithoutIdDto departmentDto) {
        // Convert departmentDto to department jpa entity
        // Department department = modelMapper.map(departmentDto, Department.class); // Using ModelMapper
        Department department = DepartmentMapper.MAPPER.toDepartment(departmentDto);

        Department saved = departmentRepository.save(department);

        // return modelMapper.map(saved, DepartmentDto.class); // Using ModelMapper
        return DepartmentMapper.MAPPER.toDepartmentDto(saved);
    }

    @Override
    public DepartmentDto findByCode(String code) {
        Department department = departmentRepository.findByCode(code);

        // return modelMapper.map(department, DepartmentDto.class); // Using ModelMapper
        return DepartmentMapper.MAPPER.toDepartmentDto(department);
    }
}