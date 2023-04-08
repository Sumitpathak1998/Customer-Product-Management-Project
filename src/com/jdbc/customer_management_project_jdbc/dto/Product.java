package com.jdbc.customer_management_project_jdbc.dto;

public class Product {

	private int productId ; 
	private String productName ; 
	private double productPrice ; 
	private String productAvilable;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductAvilable() {
		return productAvilable;
	}
	public void setProductAvilable(String productAvilable) {
		this.productAvilable = productAvilable;
	} 
	
	
}
