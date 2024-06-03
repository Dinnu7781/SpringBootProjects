package com.springboot.departmentservice.mapper;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.enitity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper mapper = Mappers.getMapper(DepartmentMapper.class);

    Department mapToDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO mapToDepartmentDto(Department department);
}
