package com.jdbc.customer_management_project_jdbc.service;

import java.util.List;

import com.jdbc.customer_management_project_jdbc.dao.AdminDao;
import com.jdbc.customer_management_project_jdbc.dto.Admin;

public class AdminService {

	AdminDao adminDao = new AdminDao(); 
	
	public void insertAdmin( Admin admin ) 
	{
		adminDao.insertAdmin(admin);
	}
	public void getById( int id ) 
	{
		int id1 = adminDao.getById(id);
		if ( id1 == id) {
			System.out.println("Enetred Id member present in Server");
		}else {
			System.out.println("Eneterd Id member not Present in Server");
		}
	}
	public void updateAdmin( int id , String name , String email) 
	{
		int id1 = adminDao.getById(id); 
		if ( id1 == id) {
			adminDao.updateAdmin(id, name, email);
		}else {
			System.out.println("Please check the Id details");
		}
	}
	public void deleteAdmin( int id)
	{
		int id1 = adminDao.getById(id); 
		if ( id1 == id) {
			adminDao.deleteAdmin(id);
		}else {
			System.out.println("Please check the Id details");
		}
	}
	public String LoginAdmin( String name , String email)
	{
		List<Admin> list = adminDao.LoginAdmin(name, email);
		
		for ( Admin admin : list) {
		
			String name1 = admin.getAdminName();
			String email1 = admin.getAdminEmail(); 
			
			if ( name1.equalsIgnoreCase(name) && email1.equalsIgnoreCase(email))
			{
				System.out.println("Login Successfully");
				return  "Login Successfully" ; 
			}else {
				System.err.println("Your username and email not matched");
				return "Your username and email not matched" ; 
				
			}
		}
		return null ; 
	}
}
