package com.springboot.employeeservice.service;

import com.springboot.employeeservice.dto.DepartmentDTO;
import com.springboot.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
//@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIClient {
    @GetMapping("api/department/{department-code}")
    DepartmentDTO getDepartmentByCode(@PathVariable("department-code") String departmentCode);
//    @GetMapping("api/organization/{organization-code}")
//    OrganizationDto getOrganizationByCode(@PathVariable("organization-code") String organizationCode);
}
