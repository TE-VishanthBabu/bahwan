package com.bahwan.springsecurityjwt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bahwan.springsecurityjwt.exception.CustomException;
import com.bahwan.springsecurityjwt.model.EmployeeResponse;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<EmployeeResponse> customException(CustomException e) {
		EmployeeResponse response = new EmployeeResponse(true, e.getMessage());
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<EmployeeResponse> handleMANVE(MethodArgumentNotValidException exception) {
		EmployeeResponse response = new EmployeeResponse(true, exception.getFieldError().getDefaultMessage());
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.NOT_ACCEPTABLE);
	}
}
