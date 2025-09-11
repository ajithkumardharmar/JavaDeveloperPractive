package com.example.spring_boot_tutorial.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_tutorial.dto.DepartmentDTO;
import com.example.spring_boot_tutorial.entity.Department;
import com.example.spring_boot_tutorial.error.DepartmentNotFound;
import com.example.spring_boot_tutorial.service.DepartmentService;

import jakarta.validation.Valid;


@RestController
@EnableCaching
public class DepartmentController {
		
		@Autowired
		private DepartmentService departmentService;
		
		@PostMapping("/departments")
		public Department saveDepartment(@Valid @RequestBody Department department) {
			
			return departmentService.saveDepartment(department);
		}
		
		@GetMapping("/departments")
		public List<Department> fetchDepartmentList(){
			return departmentService.fetchDepartmentList();
		}
		
		@GetMapping("/departments/{id}")
		public Department fetchDepartmentFetchById(@PathVariable("id") Long departmetnId) throws DepartmentNotFound{
			return departmentService.fetchDepartmentFetchById(departmetnId);
		}
		
		@DeleteMapping("/departments/{id}")
		public String deleteDepartmentById(@PathVariable("id") Long departmetnId){
			departmentService.deleteDepartmentById(departmetnId);
			return "Department Deleted succussfully";
		}
		
		@PutMapping("/departments/{id}")
		public Department updateDepartmentById(@PathVariable("id") Long departmetnId,
								@RequestBody Department department){
			
			return departmentService.updateDepartmentById(departmetnId,department);
		}
		
		@GetMapping("/departments/name/{name}")
		public Department fetchDepartmentFetchByName(@PathVariable("name") String departmentName){
			return departmentService.fetchDistinctByDepartmentName(departmentName);
		}
		
		@GetMapping("/departments/nameList/{name}")
		public List<DepartmentDTO> fetchDepartmentListFetchByName(@PathVariable("name") String departmentName){
			return departmentService.fetchDepartmentListFetchByName(departmentName);
		}
		
}
