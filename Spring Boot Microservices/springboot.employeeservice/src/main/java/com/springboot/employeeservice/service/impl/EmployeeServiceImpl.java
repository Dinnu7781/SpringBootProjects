package com.springboot.employeeservice.service.impl;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.dto.OrganizationDto;
import com.springboot.employeeservice.entity.Employee;
import com.springboot.employeeservice.exception.ResourceNotFoundException;
import com.springboot.employeeservice.mapper.EmployeeMapper;
import com.springboot.employeeservice.repository.EmployeeRepository;
import com.springboot.employeeservice.service.APIClient;
import com.springboot.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapper.mapToEmployee(employeeDTO);
//        Employee employee = new Employee(
//                employeeDTO.getId(),
//                employeeDTO.getFirstName(),
//                employeeDTO.getLastName(),
//                employeeDTO.getEmail()
//        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapper.mapToEmployeeDto(savedEmployee);
//        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );
        return savedEmployeeDTO;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "employeeId", employeeId)
        );
//        Using RestTemplate:
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();
//        Using WebClient:
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();
//        Using APIClient OpenFeign:
        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organization/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        EmployeeDTO employeeDTO = EmployeeMapper.mapper.mapToEmployeeDto(employee);
//        EmployeeDTO employeeDTO = new EmployeeDTO(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDTO, departmentDTO);
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        apiResponseDTO.setOrganizationDto(organizationDto);
        return apiResponseDTO;
    }
}
