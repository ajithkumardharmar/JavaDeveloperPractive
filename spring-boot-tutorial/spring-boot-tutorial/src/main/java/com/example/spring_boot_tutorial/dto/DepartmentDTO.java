package com.example.spring_boot_tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DepartmentDTO {
	
	 private String departmentName;
	 private String departmentAddres;
	 private String departmentCode;
	    
}
