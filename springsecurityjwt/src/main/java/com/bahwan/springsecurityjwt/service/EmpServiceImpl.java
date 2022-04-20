package com.bahwan.springsecurityjwt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bahwan.springsecurityjwt.dao.EmpDao;
import com.bahwan.springsecurityjwt.exception.CustomException;
import com.bahwan.springsecurityjwt.model.EmployeeInfo;

@Service
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmpDao dao;

	@Override
	public EmployeeInfo create(EmployeeInfo info) {
		if (info != null) {
			return dao.save(info);
		}
		throw new CustomException("Enter Valid Credentials");
	}

	@Override
	@Transactional
	public EmployeeInfo update(EmployeeInfo info) {
		
		if(dao.existsById(info.getId())) {
			EmployeeInfo oldInfo = dao.getById(info.getId());
			if(info.getUserName() != null && !info.getUserName().isEmpty()) {
				oldInfo.setUserName(info.getUserName());
			}
			if(info.getDob() != null) {
				oldInfo.setDob(info.getDob());
			}
			if(info.getMobileNumber() != null) {
				oldInfo.setMobileNumber(info.getMobileNumber());
			}
			return dao.save(oldInfo);
		}
		throw new CustomException("Id is not found");
	}
	


	@Override
	@Transactional
	public boolean delete(Integer id) {
		if (dao.existsById(id)) {
			if (id != null) {
				dao.deleteById(id);
			}
			return true;

		} else {
			throw new CustomException("id is not valid");
		}

	}

}
