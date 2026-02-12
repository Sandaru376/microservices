package com.springbootacademy.employee_service.service;

import com.springbootacademy.employee_service.dto.ApiResponseDto;
import com.springbootacademy.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
