package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.dto.DepartmentWithoutIdDto;

public interface DepartmentService {
    DepartmentDto store(DepartmentWithoutIdDto departmentDto);
    DepartmentDto findByCode(String code);
}