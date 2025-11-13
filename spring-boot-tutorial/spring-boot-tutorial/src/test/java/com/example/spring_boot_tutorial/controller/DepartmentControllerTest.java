package com.example.spring_boot_tutorial.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.spring_boot_tutorial.entity.Department;
import com.example.spring_boot_tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	@Test
	void testTetchDepartmentList() throws Exception{
		List<Department>  deptList = List.of(
				new Department(1, "Java Developer", "Madurai", "IT-1"),
				new Department(2, "UI Dev", "Chennai", "IT-2")
				);
		when(departmentService.fetchDepartmentList()).thenReturn(deptList);
		
		mockMvc.perform(get("/departments"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].departmentId").value(1L))
		.andExpect(jsonPath("$[0].departmentName").value("Java Developer"));
	}
	
	@Test
	void testFetchDepartmentFetchById() throws Exception {
		
		Department dept = new Department();
		dept.setDepartmentId(1);
		dept.setDepartmentName("Java Developer");
        dept.setDepartmentAddres("Madurai");
        dept.setDepartmentCode("IT-1");
        
        when(departmentService.fetchDepartmentFetchById(1L)).thenReturn(dept);
        
        mockMvc.perform(get("/departments/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.departmentId").value(1L))
            .andExpect(jsonPath("$.departmentName").value("Java Developer"))
            .andExpect(jsonPath("$.departmentAddres").value("Madurai"))
            .andExpect(jsonPath("$.departmentCode").value("IT-1"));
	}
	
	
}
