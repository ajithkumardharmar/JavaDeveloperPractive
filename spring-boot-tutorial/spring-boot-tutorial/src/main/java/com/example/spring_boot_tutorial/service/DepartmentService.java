package com.example.spring_boot_tutorial.service;

import java.util.List;

import com.example.spring_boot_tutorial.dto.DepartmentDTO;
import com.example.spring_boot_tutorial.entity.Department;
import com.example.spring_boot_tutorial.error.DepartmentNotFound;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentFetchById(Long departmetnId) throws DepartmentNotFound;

	public void deleteDepartmentById(Long departmetnId);

	public Department updateDepartmentById(Long departmetnId, Department department);

	public Department fetchDistinctByDepartmentName(String departmentName);
	
	public List<DepartmentDTO> fetchDepartmentListFetchByName(String departmentName);

}
