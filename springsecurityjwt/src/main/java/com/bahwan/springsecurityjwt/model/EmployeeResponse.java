package com.bahwan.springsecurityjwt.model;

public class EmployeeResponse {
	
	private boolean error;
	private Object data;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeResponse(boolean error, Object data) {
		super();
		this.error = error;
		this.data = data;
	}
	@Override
	public String toString() {
		return "EmployeeResponse [error=" + error + ", data=" + data + "]";
	}
	

}
