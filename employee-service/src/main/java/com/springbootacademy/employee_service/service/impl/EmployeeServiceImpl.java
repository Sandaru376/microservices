package com.springbootacademy.employee_service.service.impl;

import com.springbootacademy.employee_service.dto.ApiResponseDto;
import com.springbootacademy.employee_service.dto.DepartmentDto;
import com.springbootacademy.employee_service.dto.EmployeeDto;
import com.springbootacademy.employee_service.entity.Employee;
import com.springbootacademy.employee_service.repository.EmployeeRepository;
import com.springbootacademy.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;

    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

//    @Override
//    public ApiResponseDto getEmployeeById(Long id) {
//
//        Employee employee = employeeRepository.findById(id).get();
//
////        ResponseEntity<DepartmentDto> responseEntity =
////                restTemplate.getForEntity(
////                        "http://localhost:8081/api/departments/" + employee.getDepartmentCode(),
////                        DepartmentDto.class
////                );
//
//       
//
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail(),
//                employee.getDepartmentCode()
//        );
//
//        ApiResponseDto apiResponseDto = new ApiResponseDto(
//                employeeDto,
//                departmentDto
//        );
//
//        return apiResponseDto;
//    }



    @Override
    public ApiResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        // Call Department Service using WebClient
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8081/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        return new ApiResponseDto(employeeDto, departmentDto);
    }
}
