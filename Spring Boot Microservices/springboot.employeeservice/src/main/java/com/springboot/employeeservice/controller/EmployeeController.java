package com.springboot.employeeservice.controller;

import com.springboot.employeeservice.dto.APIResponseDTO;
import com.springboot.employeeservice.dto.EmployeeDTO;
import com.springboot.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("createEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
