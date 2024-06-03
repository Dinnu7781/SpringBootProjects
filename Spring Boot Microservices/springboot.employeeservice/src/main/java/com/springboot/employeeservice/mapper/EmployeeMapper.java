package com.springboot.employeeservice.mapper;



import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDTO employeeDTO);
}
