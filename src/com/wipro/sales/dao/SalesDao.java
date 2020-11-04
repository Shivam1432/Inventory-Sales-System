package com.wipro.sales.dao;

import java.sql.*;
import java.util.*;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;
import java.util.Date;

public class SalesDao {
	public int insertSales(Sales sales) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO HR.TBL_SALES VALUES(?, ?, ?, ?, ?)";
		
		//java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(sales.getSalesDate().getTime());
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sales.getSalesID());
			pstmt.setDate(2, sqlDate);
			pstmt.setString(3, sales.getProductID());
			pstmt.setInt(4, sales.getQuantitySold());
			pstmt.setDouble(5, sales.getSalesPricePerUnit());
			int t=pstmt.executeUpdate();
			if (t == 1) 
				return 1;
			else
				return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public String generateSalesID(Date salesDate) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT HR.SEQ_SALES_ID.NEXTVAL FROM DUAL";
		
		int SEQ_SALES_ID = 0;
		String out = salesDate.toString().substring(salesDate.toString().length()-2, salesDate.toString().length());
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			SEQ_SALES_ID = rs.getInt(1);
			
			
			out += SEQ_SALES_ID;
			return out;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	public ArrayList<SalesReport> getSalesReport() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM HR.V_SALES_REPORT";
		
		ArrayList<SalesReport> list = new ArrayList<SalesReport>();
		
		try {
			conn = DBUtil.getDBConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SalesReport salesReport = new SalesReport();
				salesReport.setSalesID(rs.getString(1));
				salesReport.setSalesDate(rs.getDate(2));
				salesReport.setProductID(rs.getString(3));
				salesReport.setProductName(rs.getString(4));
				salesReport.setQuantitySold(rs.getInt(5));
				salesReport.setProductUnitPrice(rs.getDouble(6));
				salesReport.setSalesPricePerUnit(rs.getDouble(7));
				salesReport.setProfitAmount(rs.getDouble(8));
				list.add(salesReport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		
		return list;
	}
}
