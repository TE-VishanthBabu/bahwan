package com.bahwan.excel.model;

import java.io.Serializable;

public class HeaderModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productid;
	
	private String name;
	
	private String cost;
	
	private String categry;
	
	private String location;
	
	private String quantity;
	
	private String totalValue;

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCategry() {
		return categry;
	}

	public void setCategry(String categry) {
		this.categry = categry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HeaderModel(String productid, String name, String cost, String categry, String location) {
		super();
		this.productid = productid;
		this.name = name;
		this.cost = cost;
		this.categry = categry;
		this.location = location;
	}

	public HeaderModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}

}
