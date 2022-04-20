package com.bahwan.excel.model;

import java.io.Serializable;

public class ExcelModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String productName;

	private Double price;

	private Double quantity;

	private Double totalValue;

	private String category;

	private String shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ExcelModel(String id, String productName, Double price, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
	}

	public ExcelModel() {
		super();
	}

	@Override
	public String toString() {
		return "ExcelModel [id=" + id + ", productName=" + productName + ", price=" + price + ", category=" + category
				+ "]";
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}
