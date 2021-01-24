package com.wipro.sales.bean;

import java.sql.Date;

public class Receipt {
	private String salesID;
	private Date salesDate;
	private String productName;
	private String productID;
	private int quantity;
	private double salesPricePerUnit;
	private String userName;
	private String itemSold;
	public String getSalesID() {
		return salesID;
	}
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getItemSold() {
		return itemSold;
	}
	public void setItemSold(String itemSold) {
		this.itemSold = itemSold;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
