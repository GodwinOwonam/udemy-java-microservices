package net.javaguides.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.dto.DepartmentWithoutIdDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    // Create store department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> store(@RequestBody DepartmentWithoutIdDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.store(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
        DepartmentDto departmentDto = departmentService.findByCode(code);

        return  new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}