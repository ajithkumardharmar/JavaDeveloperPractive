package com.example.spring_boot_tutorial.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Department implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6988526322103113182L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentId;
	
	@NotBlank(message = "Plesae Add departmentName")
	private String departmentName;
	
	private String departmentAddres;

	private String departmentCode;

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddres() {
		return departmentAddres;
	}

	public void setDepartmentAddres(String departmentAddres) {
		this.departmentAddres = departmentAddres;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Department(long departmentId, @NotBlank(message = "Plesae Add departmentName") String departmentName,
			String departmentAddres, String departmentCode) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddres = departmentAddres;
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentAddres="
				+ departmentAddres + ", departmentCode=" + departmentCode + "]";
	}

	public Department() {
		super();
	}
	
	

}
