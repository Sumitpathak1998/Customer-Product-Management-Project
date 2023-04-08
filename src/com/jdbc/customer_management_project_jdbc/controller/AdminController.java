package com.jdbc.customer_management_project_jdbc.controller;

import java.util.*;

import com.jdbc.customer_management_project_jdbc.dto.Admin;
import com.jdbc.customer_management_project_jdbc.service.AdminService;

public class AdminController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AdminService service = new AdminService(); 
		
		System.out.println("Login to Server");
		System.out.println("Enter Your Username ");
		String name1 = sc.next();
		name1 += sc.nextLine();
		System.out.println("Enter the email id");
		String email1 = sc.next(); 
		
		String result = service.LoginAdmin(name1, email1); 
		
		if (result.equalsIgnoreCase("login successfully")) 
		{
			while(true) {
				
				System.out.println("1. Insert \n2. GetById \n3. Update \n4. Delete \n5. Sign Out");
				int select = sc.nextInt(); 
				
				switch(select) {
				case 1 :{
					int press = 0 ; 
					do {
						Admin admin = new Admin(); 
						
						System.out.println("Enter the admin id");
						int id = sc.nextInt();
						System.out.println("Enter the admin Name");
						String name = sc.next(); 
						name += sc.nextLine();
						System.out.println("Enter the admin email");
						String email = sc.next();
						
						admin.setAdminId(id);
						admin.setAdminName(name);
						admin.setAdminEmail(email);
						
						service.insertAdmin(admin);
						
						System.out.println("If you want to Continoue the data data Press 1");
						press = sc.nextInt();
					}while(press == 1);
				}break ; 
				case 2:{
					System.out.println("Enter the Id for Check that member data Present or not ");
					int id = sc.nextInt();
					service.getById(id);
				}break ;
				case 3:{
					System.out.println("Enter the Id for Update the data");
					int id = sc.nextInt();
					System.out.println("Enter the new Name");
					String name = sc.next(); 
					System.out.println("Enter the new email");
					String email = sc.next(); 
					
					service.updateAdmin(id, name, email);
				}break ;
				case 4:{
					System.out.println("Enter the id for Delete the data");
					int id = sc.nextInt(); 
					service.deleteAdmin(id);
				}break ;
				case 5: {
					System.out.println("Out of the Server");
					System.exit(0);
				}
				}
			}
		}
	}	
}
