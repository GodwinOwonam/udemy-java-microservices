package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.EmployeeWithDepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeWithoutIdDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exceptions.ResourceNotFoundException;
import net.javaguides.employeeservice.mappers.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.DepartmentServiceAPIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    // private ModelMapper modelMapper;
    /*private RestTemplate restTemplate;

    private WebClient webClient;*/

    private DepartmentServiceAPIClient departmentServiceAPIClient;

    @Override
    public EmployeeDto create(EmployeeWithoutIdDto employeeDto) {
        // Employee employee = modelMapper.map(employeeDto, Employee.class); // Using ModelMapper

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());

        Employee saved = employeeRepository.save(employee);

        // return modelMapper.map(saved, EmployeeDto.class); // Using ModelMapper
        return new EmployeeDto(
            saved.getId(),
            saved.getFirstName(),
            saved.getLastName(),
            saved.getEmail(),
            saved.getDepartmentCode()
        );
    }

    @Override
    public EmployeeWithDepartmentDto getById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        // return modelMapper.map(employee, EmployeeDto.class); // Using Model Mapper

        // Using RestTemplate
        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
            "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
            DepartmentDto.class
        );

        DepartmentDto departmentDto = responseEntity.getBody();*/

        // Using WebClient
        /*DepartmentDto departmentDto = webClient.get()
            .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
            .retrieve()
            .bodyToMono(DepartmentDto.class)
            .block();*/

        DepartmentDto departmentDto = departmentServiceAPIClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getDepartmentCode()
        );

        return new EmployeeWithDepartmentDto(
            employeeDto,
            departmentDto
        );
    }
}