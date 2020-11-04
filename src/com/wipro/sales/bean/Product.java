package com.wipro.sales.bean;

public class Product {
private String productName;
private String productID;
private int quantityOnHand;
private double productUnitPrice;
private int reorderLevel;
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
public int getQuantityOnHand() {
	return quantityOnHand;
}
public void setQuantityOnHand(int quantityOnHand) {
	this.quantityOnHand = quantityOnHand;
}
public double getProductUnitPrice() {
	return productUnitPrice;
}
public void setProductUnitPrice(double productUnitPrice) {
	this.productUnitPrice = productUnitPrice;
}
public int getReorderLevel() {
	return reorderLevel;
}
public void setReorderLevel(int reorderLevel) {
	this.reorderLevel = reorderLevel;
}

}
