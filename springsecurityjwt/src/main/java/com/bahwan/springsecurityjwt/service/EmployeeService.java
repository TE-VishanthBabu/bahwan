package com.bahwan.springsecurityjwt.service;

import com.bahwan.springsecurityjwt.model.EmployeeInfo;

public interface EmployeeService {

	public EmployeeInfo create(EmployeeInfo info);

	public EmployeeInfo update(EmployeeInfo info);

	public boolean delete(Integer id);

}
