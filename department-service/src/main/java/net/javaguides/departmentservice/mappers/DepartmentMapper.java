package net.javaguides.departmentservice.mappers;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.dto.DepartmentWithoutIdDto;
import net.javaguides.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDepartmentDto(Department department);

    Department toDepartment(DepartmentDto departmentDto);

    DepartmentWithoutIdDto toDepartmentWithoutIdDto(Department department);

    Department toDepartment(DepartmentWithoutIdDto departmentWithoutIdDto);
}
