package net.javaguides.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.EmployeeWithDepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeWithoutIdDto;
import net.javaguides.employeeservice.exceptions.ErrorDetails;
import net.javaguides.employeeservice.exceptions.ResourceNotFoundException;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeWithoutIdDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.create(employeeDto);

        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeWithDepartmentDto> getEmployee(@PathVariable("id") Long employeeId) {
        EmployeeWithDepartmentDto employeeWithDepartment = employeeService.getById(employeeId);

        return new ResponseEntity<>(employeeWithDepartment, HttpStatus.OK);
    }

    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
        ResourceNotFoundException exception,
        WebRequest webRequest
    ) {
        ErrorDetails errorDetails = new ErrorDetails(
            LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false),
            "EMPLOYEE_NOT_FOUND"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}