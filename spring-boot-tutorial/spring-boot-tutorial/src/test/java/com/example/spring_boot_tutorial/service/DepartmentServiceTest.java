package com.example.spring_boot_tutorial.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring_boot_tutorial.entity.Department;
import com.example.spring_boot_tutorial.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	
	
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	@InjectMocks
	private DepartmentServiceImpl departmentService;
	
	@BeforeEach
	void setUP() {
		
		Department dept = new Department(1L,"IT","Madurai","IT-1");
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(dept);
	}
	
	@Test
	@DisplayName("Get Data based on valid Department Name")
//	@Disabled  --> this annotation for skip test case method
	public void whenValidDepartmentName_thenDepartmentFound() {
		String departmentName = "IT";
		
		Department found = departmentService.fetchDistinctByDepartmentName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

}
