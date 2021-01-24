package com.wipro.sales.service;

import com.wipro.sales.dao.OrdersDao;
import com.wipro.sales.dao.StockDao;
import java.util.ArrayList;
import com.wipro.sales.bean.Orders;
import com.wipro.sales.bean.Receipt;

public class User {
	private static OrdersDao orderDao = new OrdersDao();
	private static StockDao stockDao = new StockDao();
	
	public String insertOrder(Orders order) {
		if (stockDao.getStock(order.getProductID())==null )
			return "Unknown Product for sales";
		
		if(!order.getProductID().equals(stockDao.getStock(order.getProductID()).getProductID()))
			return "Product ID does not match";
		
		if (stockDao.getStock(order.getProductID()).getQuantityOnHand() < order.getQuantity())
			return "Not enough stock on hand for sales";
		
		if (orderDao.insertOrder(order) == 1)
			return "Order placed successfully";
		else 
			return "order cannot be placed";
	}
	public ArrayList<Receipt> getReceipt(String name) {	
		return orderDao.getReceipt(name);
	}
}
