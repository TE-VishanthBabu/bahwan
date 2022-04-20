package com.bahwan.partialsearch.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bahwan.partialsearch.bean.EmployeeInfo;
import com.bahwan.partialsearch.dao.EmployeeDao;

@RequestMapping("/bct")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	@GetMapping(path = "api/getall")
	public List<EmployeeInfo> getAll(@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return dao.findBynameContaining(name, pageable).toList();
	}

}
