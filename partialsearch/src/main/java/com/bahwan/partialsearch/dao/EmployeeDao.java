package com.bahwan.partialsearch.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bahwan.partialsearch.bean.EmployeeInfo;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeInfo, Integer> {

	@Query("select i from EmployeeInfo i where i.name LIKE ?1%")
	public Page<EmployeeInfo> findBynameContaining(String name, Pageable pageable);

}
