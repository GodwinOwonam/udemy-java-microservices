package net.javaguides.employeeservice.mappers;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.EmployeeWithoutIdDto;
import net.javaguides.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeWithoutIdDto toEmployeeWithoutIdDto(Employee employee);
    Employee toEmployee(EmployeeWithoutIdDto employeeDto);
}
