package com.jdbc.customer_management_project_jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getConnection() {
		
		try {
			//Step-1 load the Driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2 Establish a Connection
			String url = "jdbc:mysql://localhost:3306/customer-management-project";
			String username = "root" ; 
			String password = "root" ;
			
			Connection connection = DriverManager.getConnection(url, username, password); 
			
			return connection ; 
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
}
