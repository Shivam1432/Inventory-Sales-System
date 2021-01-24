package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.sales.util.DBUtil;
import com.wipro.sales.bean.*;

public class OrdersDao {
	public int insertOrder(Orders order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO HR.TBL_ORDERS VALUES(?, ?, ?, ?, ?)";
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getProductID());
			pstmt.setString(2, order.getProductName());
			pstmt.setInt(3, order.getQuantity());
			pstmt.setString(4, order.getItemSold());
			pstmt.setString(5, order.getUname());
			int t=pstmt.executeUpdate();
			
			if (t == 1) return 1;
			else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public Orders getOrder(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM HR.TBL_ORDERS WHERE USER_NAME = ?";
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			Orders order=new Orders();
			while(rs.next())
			{
				order.setProductID(rs.getString(1));
				order.setProductName(rs.getString(2));
				order.setQuantity(rs.getInt(3));
				order.setItemSold(rs.getString(4));
				order.setUname(rs.getString(5));
			}
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	public int updateOrder(String productID, int soldQty,String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE HR.TBL_ORDERS SET Quantity = Quantity - ?,Item_Sold='Sold' WHERE Product_ID = ? AND USER_NAME = ?";
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, soldQty);
			pstmt.setString(2, productID);
			pstmt.setString(3, name);
			int t=pstmt.executeUpdate();
			
			if (t == 1) return 1;
			else return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<Receipt> getReceipt(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM HR.V_RECEIPT1 WHERE ITEM_SOLD='Sold' AND USER_NAME = ?";
		
		ArrayList<Receipt> list = new ArrayList<Receipt>();
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Receipt Report = new Receipt();
				Report.setSalesID(rs.getString(1));
				Report.setSalesDate(rs.getDate(2));
				Report.setProductID(rs.getString(3));
				Report.setProductName(rs.getString(4));
				Report.setQuantity(rs.getInt(5));
				Report.setUserName(rs.getString(6));
				Report.setSalesPricePerUnit(rs.getDouble(7));
				Report.setItemSold(rs.getString(8));
				list.add(Report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		
		return list;
	}
}
