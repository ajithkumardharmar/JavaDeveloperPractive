package com.ajith.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name =  "emp_table")
public class Employee {
	
	@Id
	private int eid;
	private EmployeeName emloyeeName;
	@Transient
	private String role;
	@Column(name = "emp_experience")
	private int experience;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public EmployeeName getEmloyeeName() {
		return emloyeeName;
	}
	public void setEmloyeeName(EmployeeName emloyeeName) {
		this.emloyeeName = emloyeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", emloyeeName=" + emloyeeName + ", role=" + role + ", experience=" + experience
				+ "]";
	}
	
	
	
	
	
	
	
	
}
