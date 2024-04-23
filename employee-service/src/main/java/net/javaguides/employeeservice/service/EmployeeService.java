package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.EmployeeWithoutIdDto;

public interface EmployeeService {
    EmployeeDto create(EmployeeWithoutIdDto employeeDto);
    EmployeeDto getById(Long employeeId);
}