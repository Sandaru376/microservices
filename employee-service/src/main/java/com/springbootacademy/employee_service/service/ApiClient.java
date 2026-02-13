package com.springbootacademy.employee_service.service;

import com.springbootacademy.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8081")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("/api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable("departmentCode") String departmentCode);

}