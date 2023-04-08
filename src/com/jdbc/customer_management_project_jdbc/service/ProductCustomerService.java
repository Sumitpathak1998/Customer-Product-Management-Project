package com.jdbc.customer_management_project_jdbc.service;

import java.util.*;

import com.jdbc.customer_management_project_jdbc.dao.ProductCustomerDao;
import com.jdbc.customer_management_project_jdbc.dto.Customer;
import com.jdbc.customer_management_project_jdbc.dto.Product;

public class ProductCustomerService {

	ProductCustomerDao dao = new ProductCustomerDao();
	public void insertProductCustomer( Customer customer , double price) {
		
		if ( price > 7000.00 ) 
		{
			System.err.println("Product price more then 7000 not accepted");
		}else {
			dao.insertProductCustomer(customer);
		}
	}
	public void addCustomer(Customer customer) 
	{
		dao.addCustomer(customer);
	}
	public void getByIdCustomer(int id) 
	{
		int id1 = dao.getByIdCustomer(id); 
		if ( id1 == id ) {
			System.out.println("Customer Id present in Server");
		}else {
			System.out.println("Customer Id not Present in Server");
		}
	}
	public void getByIdProduct(int id) 
	{
		int id1 = dao.getByIdProduct(id); 
		if ( id1 == id ) {
			System.out.println("Product Id present in Server");
		}else {
			System.out.println("Product Id not Present in Server");
		}
	}
	public void deleteCustomer(int id) 
	{
		int id1 = dao.getByIdCustomer(id); 
		if ( id1 == id ) {
			dao.deleteCustomer(id);
		}else {
			System.out.println("Check the Entered Customer id Again");
		}
	}
	public void updateCustomer( int id , String name , String email , long phone , int productId) 
	{	
		int id1 = dao.getByIdCustomer(id); 
		if ( id1 == id ) {
			dao.updateCustomer(id, name, email, phone, productId);
		}else {
			System.out.println("Check the Entered Customer id Again");
		}
	}
	public String customerLogin ( int id , String email)
	{
		List<Customer> list = dao.customerLogin(id, email);
		
		for ( Customer customer : list) {
			
			if ( customer.getCustomerId() == id  && customer.getCustomerEmail().equalsIgnoreCase(email)) 
			{
				System.out.println("Customer login Successfully");
				return "Customer login Successfully" ; 
			}
			else {
				System.out.println("Email and id not matched");
			}
		}
		return "Email and id not matched"; 
	}
	public void addProduct(Product product , double price) 
	{
		if ( price > 7000) 
		{
			System.err.println("Product price more then 7000 not accepted");
		}else {
			dao.addProduct(product);
		}
	}
	public void updateProduct( int id , String name , double price , String avilable ) {
		
		int id1 = dao.getByIdProduct(id);
		if ( id1 == id ) {
			dao.updateProduct(id, name, price, avilable);
		}else {
			System.out.println("Check entered Product Id details");
		}
	}
	public void updateProductPrice( int id , double price)
	{
		int id1 = dao.getByIdProduct(id);
		if ( id1 == id ) {
			dao.updateProductPrice(id, price);
		}else {
			System.out.println("Check entered Product Id details");
		}
	}
	public void updateProductAvailable( int id , String available) 
	{
		int id1 = dao.getByIdProduct(id); 
		if ( id1 == id) {
			dao.updateProductAvailable(id, available);
		}else {
			System.out.println("Check entered Product Id details");
		}
	}
	public void deleteProduct( int id )
	{
		int id1 = dao.getByIdProduct(id); 
		if( id1 == id) {
			dao.deleteProduct(id);
		}else {
			System.out.println("Check entered Product Id details");
		}
	}
	public List<Customer> displayCustomer()
	{
		return dao.displayCustomer();
	}
	public List<Product> displayProduct()
	{
		return dao.displayProduct();
	}
}
