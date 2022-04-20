package com.bahwan.pdf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DataModel implements Serializable {

	private String[] header;

	private List<String[]> users;

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	public List<String[]> getUsers() {
		return users;
	}

	public void setUsers(List<String[]> users) {
		this.users = users;
	}

}
