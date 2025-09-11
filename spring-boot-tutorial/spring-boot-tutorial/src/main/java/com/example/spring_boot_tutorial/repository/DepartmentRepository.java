package com.example.spring_boot_tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_tutorial.dto.DepartmentDTO;
import com.example.spring_boot_tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	//method DepartmentName name and return type Object (Department) based automatically query frame and get data  
	public Department findByDepartmentName(String departmentName);
	
	
	//IgnoreCase base fetch data case ignoring
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
	@Query("SELECT distinct new com.example.spring_boot_tutorial.dto.DepartmentDTO(d.departmentName, d.departmentAddres, d.departmentCode) FROM Department d WHERE d.departmentName = :name")
	public List<DepartmentDTO> findDistinctByDepartmentName(@Param("name") String  name);

}
