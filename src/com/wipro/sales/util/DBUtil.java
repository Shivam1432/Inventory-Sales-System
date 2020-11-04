package com.wipro.sales.util;

import java.sql.*;
public class DBUtil {
    private static Connection con;
	public static Connection getDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");
			return con;
		}
		catch(Exception e)
		{
			System.out.println("Connection could not be established");
			e.printStackTrace();
			return null;
		}
	}

}
