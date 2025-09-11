package com.ajith.vo;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Cacheable;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	private int rollno;
	private String StudentName;
	private int mark;
	@ManyToMany(mappedBy = "student")
	private Collection<Laptop> laptop = new ArrayList<Laptop>();
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public Collection<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(Collection<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", StudentName=" + StudentName + ", mark=" + mark + ", laptop=" + laptop
				+ "]";
	}
	
	
	
	

}
