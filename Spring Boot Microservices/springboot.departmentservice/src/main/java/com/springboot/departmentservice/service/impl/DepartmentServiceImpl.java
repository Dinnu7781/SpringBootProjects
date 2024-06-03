package com.springboot.departmentservice.service.impl;

import com.springboot.departmentservice.dto.DepartmentDTO;
import com.springboot.departmentservice.enitity.Department;
import com.springboot.departmentservice.exception.ResourceNotFoundException;
import com.springboot.departmentservice.mapper.DepartmentMapper;
import com.springboot.departmentservice.repository.DepartmentRepository;
import com.springboot.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;
//    DepartmentMapper departmentMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = DepartmentMapper.mapper.mapToDepartment(departmentDTO);

//        Department department = new Department(
//          departmentDTO.getId(),
//          departmentDTO.getDepartmentName(),
//          departmentDTO.getDepartmentDescription(),
//          departmentDTO.getDepartmentCode()
//        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDTO = DepartmentMapper.mapper.mapToDepartmentDto(savedDepartment);

//        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );
        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Optional<Department> optionalDepartment = Optional.ofNullable(departmentRepository.findByDepartmentCode(departmentCode));
        if(optionalDepartment.isEmpty()){
            throw new ResourceNotFoundException(
              "Department", "departmentCode", departmentCode
            );
        }

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
//        if(code == null){
//
//        }
        DepartmentDTO departmentDTO = DepartmentMapper.mapper.mapToDepartmentDto(department);
//        DepartmentDTO departmentDTO = new DepartmentDTO(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        return departmentDTO;
    }
}
