package com.springbootacademy.department_service.service.impl;

import com.springbootacademy.department_service.dto.DepartmentDto;
import com.springbootacademy.department_service.entity.Department;
import com.springbootacademy.department_service.repository.DepartmentRepository;
import com.springbootacademy.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceIMPL implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    public DepartmentServiceIMPL(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

//    @Override
//    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto   .getDepartmentCode()
//        );
//
//        Department savedepartment1=departmentRepository.save(department);
//
//        DepartmentDto SaveddepartmentDto=new DepartmentDto(
//                savedepartment1.getId(),
//                savedepartment1.getDepartmentName(),
//                savedepartment1.getDepartmentDescription(),
//                savedepartment1.getDepartmentCode()
//        );
//
//        return SaveddepartmentDto;
//    }
//
//    @Override
//    public DepartmentDto getDepartmentByCode(String code) {
//        Department department=departmentRepository.findByDepartmentCode(code);
//        DepartmentDto departmentDto=new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
//
//        return departmentDto;
//    }
}
