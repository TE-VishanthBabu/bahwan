package com.bahwan.springsecurityjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bahwan.springsecurityjwt.model.EmployeeInfo;

@Repository
public interface EmpDao extends JpaRepository<EmployeeInfo, Integer> {

}
