package com.wipro.sales.bean;

public class Orders {
	private String productName;
	private String productID;
	private int quantity;
	private String itemSold;
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getItemSold() {
		return itemSold;
	}
	public void setItemSold(String itemSold) {
		this.itemSold = itemSold;
	}
	
}
