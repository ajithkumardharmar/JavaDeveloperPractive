package com.example.SpringFrameworkDemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Doctor implements Staff,BeanNameAware {
	
	private String qualification;
	
	public void assist() {
		String n = "nsdnf";
		System.out.println("Doctor is assisting");
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Doctor [qualification=" + qualification + "]";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("set bean method called");
		
	}
	@PostConstruct
	public void postConstructor() {
		System.out.println("postConstructor method called");
	}
	
	
	
	
	
}
