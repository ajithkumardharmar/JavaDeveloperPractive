package com.example.spring_boot_tutorial.repository;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.spring_boot_tutorial.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	private Department savedDepartment;
	
	@BeforeEach
	void setUp(){
		
//		Department dept = Department.builder().departmentName("Java Developer")
//				.departmentAddres("Madurai").departmentCode("IT-1").build();
		Department dept = new Department();
		dept.setDepartmentName("Java Developer");
        dept.setDepartmentAddres("Madurai");
        dept.setDepartmentCode("IT-1");
		savedDepartment = testEntityManager.persistFlushFind(dept);
		
	}
	
	@Test
	public void whenFindById_thenDepartmentFound() {
		Department dept = departmentRepository.findById(savedDepartment.getDepartmentId()).get();
		assertEquals("Java Developer", dept.getDepartmentName());
	}

}
