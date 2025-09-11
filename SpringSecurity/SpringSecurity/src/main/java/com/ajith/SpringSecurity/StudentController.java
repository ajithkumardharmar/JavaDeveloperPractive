package com.ajith.SpringSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
		public List<Student> studentList = new ArrayList<>(
				List.of(
						new Student(1,"Ajith",95),
						new Student(2,"Siva",94))
				);
		@GetMapping("/students")
		public List<Student> getStudents(){
			return studentList;
		}
		
		@GetMapping("csrf-token")
		public CsrfToken getCsrfToken(HttpServletRequest httpRequest) {
			return (CsrfToken) httpRequest.getAttribute("_csrf");
		}
		
		@PostMapping("/students")
		public List<Student> addStudents(@RequestBody Student student){
			studentList.add(student);
			
			return studentList;
		}
}
