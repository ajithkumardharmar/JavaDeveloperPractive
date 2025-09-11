package com.example.spring_boot_tutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import com.example.spring_boot_tutorial.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseStatusExceptionHandler {
	
	@ExceptionHandler(DepartmentNotFound.class)
	public ResponseEntity<ErrorMessage> getDepartmentNotFound(DepartmentNotFound depNotFound,
			 			WebRequest webRequest){
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,depNotFound.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		
	}
}
