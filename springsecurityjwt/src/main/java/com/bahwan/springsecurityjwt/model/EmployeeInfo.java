package com.bahwan.springsecurityjwt.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "emp_info")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	@NotNull(message = "Username should not be null")
	@NotEmpty(message = "Username should be Empty")
	private String userName;

	@Column(name = "mob_No")
	@NotNull(message = "MobileNumber should not be null")
	private Long mobileNumber;

	@Column
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dob;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public EmployeeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeInfo(Integer id, String userName, Long mobileNumber, Date dob) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", userName=" + userName + ", mobileNumber=" + mobileNumber + ", dob=" + dob
				+ "]";
	}

}
