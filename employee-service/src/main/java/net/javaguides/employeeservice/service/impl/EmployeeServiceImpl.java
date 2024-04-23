package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.EmployeeWithoutIdDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mappers.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto create(EmployeeWithoutIdDto employeeDto) {
        // Employee employee = modelMapper.map(employeeDto, Employee.class); // Using ModelMapper

        Employee employee = EmployeeMapper.MAPPER.toEmployee(employeeDto);

        Employee saved = employeeRepository.save(employee);

        // return modelMapper.map(saved, EmployeeDto.class); // Using ModelMapper
        return EmployeeMapper.MAPPER.toEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        // return modelMapper.map(employee, EmployeeDto.class); // Using Model Mapper
        return EmployeeMapper.MAPPER.toEmployeeDto(employee);
    }
}