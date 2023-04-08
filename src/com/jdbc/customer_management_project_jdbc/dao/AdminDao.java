package com.jdbc.customer_management_project_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.customer_management_project_jdbc.connection.JDBCConnection;
import com.jdbc.customer_management_project_jdbc.dto.Admin;
import com.mysql.cj.jdbc.JdbcConnection;

public class AdminDao {

	Connection connection = null ; 
	
	//Method for Insert the Data 
	public void insertAdmin( Admin admin ){
		
		connection = JDBCConnection.getConnection(); 
		
		//Step-3 Create a Prepared Statement 
		try {
			
			String insert = "insert into admin values( ? , ? , ? )" ;
			
			PreparedStatement preparedStatement = connection.prepareStatement(insert); 
			
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getAdminName());
			preparedStatement.setString(3, admin.getAdminEmail());
			
			preparedStatement.execute(); 
			
			System.out.println("Data inserted ....");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//Method getById
	public int getById( int id ) {
		
		connection = JDBCConnection.getConnection(); 
		
		//Step-2 Create a Prepared Statement 
		try {
			
			String select = "select * from admin where adminId = ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			
			preparedStatement.setInt(1, id);
			
			ResultSet set = preparedStatement.executeQuery(); 
			
			
			while ( set.next()) {
				
				int id1 = set.getInt("adminId"); 
				System.out.println(id1);
				return id1 ; 
			}
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0 ; 
	}
	//Method for Update the name and email 
	public void updateAdmin( int id , String name , String email) {
		
		connection = JDBCConnection.getConnection(); 
		try {
			
			String update = "update admin set adminName = ? , adminEmail = ? where adminId = ? " ;
			
			PreparedStatement preparedStatement = connection.prepareStatement(update) ; 
			
			preparedStatement.setString(1, name); 
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, id);
			
			preparedStatement.execute() ; 
			
			System.out.println("Data Updated \nAdminName = "+name+" \nAdminEmail = "+email);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Method for delete the Admin 
	public void deleteAdmin( int id) {
		
		connection = JDBCConnection.getConnection(); 
		
		try {
			
			String delete = "delete from admin where adminId = ? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(delete); 
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute(); 
			
			System.out.println("Data deleted");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}
		}	
	}
	// Method for Login in the Server
	public List<Admin> LoginAdmin( String name , String email) {
		
		connection = JDBCConnection.getConnection(); 
		
		try {
			String select = "select * from admin where adminName = ? and adminEmail = ?" ; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(select); 
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			
			ResultSet set =  preparedStatement.executeQuery();
			
			List<Admin> l1 = new ArrayList<Admin>();
			
			while(set.next()) {
				
				String name1 = set.getString("adminName"); 
				String email1 = set.getString("adminEmail");
				
				Admin admin = new Admin(); 
				
				admin.setAdminName(name1);
				admin.setAdminEmail(email1);
				
				l1.add(admin);
			}
			return l1 ; 
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null ; 
	}
}
