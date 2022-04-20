package com.bahwan.springsecurityjwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahwan.springsecurityjwt.model.EmployeeInfo;
import com.bahwan.springsecurityjwt.model.EmployeeResponse;
import com.bahwan.springsecurityjwt.service.EmployeeService;

@RestController
@RequestMapping("/bct")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping(path = "/create")
	public ResponseEntity<EmployeeResponse> create(@RequestBody @Valid EmployeeInfo info) {
		EmployeeResponse res = new EmployeeResponse(false, service.create(info));
		return new ResponseEntity<EmployeeResponse>(res, HttpStatus.OK);
	}

	@PutMapping(path = "/api/update/1")
	public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeInfo employeeInfo) {
		EmployeeResponse respone = new EmployeeResponse(false, service.update(employeeInfo));
		return new ResponseEntity<EmployeeResponse>(respone, HttpStatus.OK);
	}

	@PutMapping(path = "/api/delete/1/{id}")
	public ResponseEntity<EmployeeResponse> delete(@PathVariable Integer id) {
		service.delete(id);
		EmployeeResponse response = new EmployeeResponse(false, "Deleted Successfully");
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

}
