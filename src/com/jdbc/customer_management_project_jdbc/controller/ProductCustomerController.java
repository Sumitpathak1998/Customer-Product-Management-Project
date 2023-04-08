package com.jdbc.customer_management_project_jdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.jdbc.customer_management_project_jdbc.dto.Admin;
import com.jdbc.customer_management_project_jdbc.dto.Customer;
import com.jdbc.customer_management_project_jdbc.dto.Product;
import com.jdbc.customer_management_project_jdbc.service.AdminService;
import com.jdbc.customer_management_project_jdbc.service.ProductCustomerService;

public class ProductCustomerController {

	public static void main(String[] args) {
		
		customerProductServer();
	}	
	public static void customerProductServer() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		
			System.out.println("Welcome to Customer-Management-Project Server");
			System.out.println("1. For Edit Customer Details \n2. For Edit and Display Product & Customer details \n3. For Exit");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :{
				adminLogin();
			}break; 
			case 2 :{
				customerLogin();
			}break ; 
			case 3:{
				System.out.println("Exit from Customer-Management-Project-Server");
				System.exit(0);
			}
		}
	}
	}
	public static void adminLogin() {
	
		Scanner sc = new Scanner(System.in);
		ProductCustomerService service = new ProductCustomerService();
		Admin admin = new Admin(); 
		AdminService adminService = new AdminService();
		
		System.out.println("Login to Customer Server");
		System.out.println("Enter Your Username ");
		String name1 = sc.next();
		name1 += sc.nextLine();
		System.out.println("Enter the email id");
		String email1 = sc.next();
		
		String result = adminService.LoginAdmin(name1, email1);
		
		if(result.equalsIgnoreCase("login successfully")) {
			while(true) {
				System.out.println("Welcome Customer Server");
				System.out.println("1. Insert Customer Details \n2. GetById \n3. Update Customer Details \n4. Delete Customer Details \n5. Exit");
				int select = sc.nextInt();
				
				switch(select) {
				case 1 :{
					System.out.println("1. Insert Customer & Product \n2. Insert Customer");
					int enter = sc.nextInt();
					switch(enter) {
					case 1:{
						int press = 0 ; 
						do {
							Product product = new Product(); 
							
							System.out.println("Enter the Product Id");
							int proId = sc.nextInt(); 
							System.out.println("Enter the Product name");
							String name = sc.next();
							name += sc.nextLine();
							System.out.println("Enter the Product Price ");
							double price = sc.nextDouble(); 
							System.out.println("Enter the Product Avilablity");
							String avilable = sc.next(); 
							
							product.setProductId(proId);
							product.setProductName(name);
							product.setProductPrice(price);
							product.setProductAvilable(avilable);
							
							Customer customer = new Customer(); 
							
							System.out.println("Enter the Customer Id");
							int cusid = sc.nextInt(); 
							System.out.println("Eneter the name of Customer");
							String cusName = sc.next();
							System.out.println("Enter the Customer Email");
							String cusemail = sc.next();
							System.out.println("Enter the Customer Phone number");
							long phone = sc.nextLong(); 
							
							customer.setCustomerId(cusid);
							customer.setCustomerName(cusName);
							customer.setCustomerEmail(cusemail);
							customer.setCustomerPhone(phone);
							customer.setProduct(product);
							
							service.insertProductCustomer(customer, price);
							
							System.out.println("If you want to continoue insert press 1 ");
							press = sc.nextInt(); 
						}while(press == 1);
					}break;
					case 2 :{
						int press = 0 ; 
						do {
							Customer customer = new Customer(); 
							Product product = new Product() ; 
							System.out.println("Enter the Customer Id");
							int cusid = sc.nextInt(); 
							System.out.println("Eneter the name of Customer");
							String cusName = sc.next();
							System.out.println("Enter the Customer Email");
							String cusemail = sc.next();
							System.out.println("Enter the Customer Phone number");
							long phone = sc.nextLong(); 
							System.out.println("Enter the Product Id");
							int proid = sc.nextInt(); 
							
							customer.setCustomerId(cusid);
							customer.setCustomerName(cusName);
							customer.setCustomerEmail(cusemail);
							customer.setCustomerPhone(phone);
							product.setProductId(proid);
							
							customer.setProduct(product);
							
							service.addCustomer(customer);
							
							System.out.println("If you want to continoue insert press 1 ");
							press = sc.nextInt(); 
						}while(press == 1);
					}break;
					}
					}break; 
				case 2:{
					System.out.println("Enter the customer id for Check the Customer");
					int id = sc.nextInt();
					service.getByIdCustomer(id);	
				}break; 
				case 3 :{
					System.out.println("Enter the id for Update the Customer details");
					int id = sc.nextInt(); 
					System.out.println("Eneter the new name of Customer");
					String cusName = sc.next();
					System.out.println("Enter the new Customer Email");
					String cusemail = sc.next();
					System.out.println("Enter the Customer update Phone number");
					long phone = sc.nextLong();
					System.out.println("Enter the new Product id");
					int proid = sc.nextInt(); 
					service.updateCustomer(id, cusName, cusemail, phone, proid);
				}break ; 
				case 4 : {
					System.out.println("Enter the Customer Id for delete the record");
					int id = sc.nextInt(); 
					service.deleteCustomer(id);
				}break ;
				case 5: {
					System.out.println("Exit Customer Server");
					break ; 
				}
				}
			}
		}
	}
	// Method for Customer Login
	public static void customerLogin() {
		
		ProductCustomerService service = new ProductCustomerService(); 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Login Product Server");
		System.out.println("Enter the Customer Id ");
		int id1 = sc.nextInt();
		System.out.println("Enter the Customer Email Id");
		String email1 = sc.next(); 
		
		String result = service.customerLogin(id1, email1); 
		if ( result.equalsIgnoreCase("customer login Successfully")) {
			while(true) {
				System.out.println("welcome to Product server");
				System.out.println("1. Insert Product details \n2. GetBYId \n3. Update the Product Details \n4. Delete the Product Details \n5. Display \n6. Exit");
				int select = sc.nextInt(); 
				switch(select) {
				case 1 :{
					System.out.println("Enter the Product Id");
					int id = sc.nextInt();
					System.out.println("Enter the Product Name");
					String name = sc.next();
					name += sc.nextLine();
					System.out.println("Enter the Product Price");
					double price = sc.nextDouble();
					System.out.println("Enter the availablity of Product");
					String available = sc.next();
					
					Product product = new Product(); 
					
					product.setProductId(id);
					product.setProductName(name);
					product.setProductPrice(price);
					product.setProductAvilable(available);
					
					service.addProduct(product, price);
				}break;
				case 2 :{
					System.out.println("Enter the Product id for check the Product");
					int id = sc.nextInt();
					service.getByIdProduct(id);
				}break ; 
				case 3:{
					System.out.println("1. For Update all the details of Product \n2. For Update product price \n3. For Update Product Availablity");
					int choice = sc.nextInt();
					switch(choice) {
					case 1:{
						System.out.println("Enter the Product id for Update the data");
						int id = sc.nextInt();
						System.out.println("Enter updated product name");
						String name = sc.next();
						name += sc.nextLine();
						System.out.println("Enter the new Product price");
						double price = sc.nextDouble(); 
						System.out.println("Enter the Product Availabilty");
						String availblity = sc.next(); 
						
						service.updateProduct(id, name, price, availblity);
					}break; 
					case 2 :{
						System.out.println("Enter the Product id for Update the data");
						int id = sc.nextInt();
						System.out.println("Enter the new Product price");
						double price = sc.nextDouble();
						
						service.updateProductPrice(id, price);
					}break ; 
					case 3:{
						System.out.println("Enter the Product id for Update the data");
						int id = sc.nextInt();
						System.out.println("Enter the Product Availabilty");
						String availblity = sc.next();
						
						service.updateProductAvailable(id, availblity);
					}break ; 
					}
				}break; 
				case 4: {
					System.out.println("Enter the Id for delete the Product details");
					int id = sc.nextInt(); 
					service.deleteProduct(id);
				}break ; 
				case 5:{
					System.out.println("1. For Display Customer Details \n2. For Display Product details");
					int choice = sc.nextInt(); 
					switch(choice) {
					case 1 :{
						
						List<Customer> list =  service.displayCustomer();
						
						for( Customer customer : list) {
							
							System.out.println("Customer Id : "+customer.getCustomerId());
							System.out.println("Customer Name : "+customer.getCustomerName());
							System.out.println("Customer Email : "+customer.getCustomerEmail());
							System.out.println("Customer Phone No. : "+customer.getCustomerPhone());
							System.out.println("Product Id :"+customer.getProduct().getProductId());
							System.out.println("---------------------------------------");
						}
					}break;
					case 2 :{
						List<Product> list = service.displayProduct();
						
						for ( Product product : list) {
							
							System.out.println("Product Id : "+product.getProductId());
							System.out.println("Product Name : "+product.getProductName());
							System.out.println("Product Price : "+product.getProductPrice());
							System.out.println("Product Availablity : "+product.getProductAvilable());
							System.out.println("------------------------------------------");
							
						}
					}break; 
					}
				}break ;
				case 6: {
					System.out.println("Exit Product Server");
					System.exit(0);
				}
				}
			}
		}
	}
}
