package com.jdbc.customer_management_project_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.customer_management_project_jdbc.connection.JDBCConnection;
import com.jdbc.customer_management_project_jdbc.dto.Customer;
import com.jdbc.customer_management_project_jdbc.dto.Product;

public class ProductCustomerDao {

	/*
	 * Method for Insert Product and Customer Details 
	 * Method for Insert Customer details
	 * GetByIdCustomer - Method for See the customer Present in Server data or not 
	 * GetByIdProduct - Method for See the Product Present in Server data or not
	 * 
	 */
	Connection connection = null;

	// Method for Insert the Data of Product and Customer
	public void insertProductCustomer(Customer customer) {
		PreparedStatement preparedStatement = null;
		connection = JDBCConnection.getConnection();

		String insertProduct = "insert  into product values ( ? , ? , ? , ? )";
		String insertCustomer = " insert into customer values( ? , ? , ? , ? , ?)";
		try {

			preparedStatement = connection.prepareStatement(insertProduct);

			preparedStatement.setInt(1, customer.getProduct().getProductId());
			preparedStatement.setString(2, customer.getProduct().getProductName());
			preparedStatement.setDouble(3, customer.getProduct().getProductPrice());
			preparedStatement.setString(4, customer.getProduct().getProductAvilable());

			preparedStatement.execute();

			System.out.println("Product data ..... Inserted");

			preparedStatement = connection.prepareStatement(insertCustomer);

			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setLong(4, customer.getCustomerPhone());
			preparedStatement.setInt(5, customer.getProduct().getProductId());

			preparedStatement.execute();

			System.out.println("Customer data ....inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method for Insert the Data in Customer Table
	public void addCustomer(Customer customer) {

		Connection connection = null;
		
		connection = JDBCConnection.getConnection();
		try {
			String insert = "insert into customer values ( ? , ? , ? , ? , ? )";

			PreparedStatement preparedStatement = connection.prepareStatement(insert);

			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setLong(4, customer.getCustomerPhone());
			preparedStatement.setInt(5, customer.getProduct().getProductId());

			preparedStatement.execute();

			System.out.println("Customer Data Added");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Method for GetById
	public int getByIdCustomer(int id) {

		Connection connection = null;

		connection = JDBCConnection.getConnection();
		
		try {
			String select = "select * from customer where customerId = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(select);

			preparedStatement.setInt(1, id);

			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {

				int id1 = set.getInt("customerId");
				System.out.println(id1);
				return id1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int getByIdProduct(int id) {

		Connection connection = null;
		
		connection = JDBCConnection.getConnection();
		try {
			String select = "select * from product where productId = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(select);

			preparedStatement.setInt(1, id);

			ResultSet set = preparedStatement.executeQuery();

			while (set.next()) {

				int id1 = set.getInt("productId");
				System.out.println(id1);
				return id1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	// Method for Delete the Customer Data
	public void deleteCustomer(int id) {

		Connection connection = null;
		
		connection = JDBCConnection.getConnection();
		try {
			String delete = "delete from customer where customerId = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(delete);

			preparedStatement.setInt(1, id);

			preparedStatement.execute();

			System.out.println("Customer data ......deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Method for Update the Customer
	public void updateCustomer( int id , String name , String email , long phone , int productId) {
		
		Connection connection = null; 
		
		connection = JDBCConnection.getConnection();
		try {
			String update = "update customer set customerName = ? , customerEmail = ? , customerPhone = ? , productId = ? where customerId = ? " ;
			
			PreparedStatement preparedStatement = connection.prepareStatement(update); 
			
			preparedStatement.setInt(5, id);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setLong(3, phone);
			preparedStatement.setInt(4, productId);
			
			preparedStatement.execute();
			
			System.out.println("Data updated \nName : "+name+"\nEmail : "+email+"\nPhone : "+phone+"\nProductId : "+productId);
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close(); 
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Method for Customer Login
	public List<Customer> customerLogin ( int id , String email) {
		
		Connection connection = null; 
		
		connection = JDBCConnection.getConnection(); 
		
		try {
			String select = "select * from customer where customerId = ? and customerEmail = ? "; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(select); 
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, email);
			
			ResultSet set =  preparedStatement.executeQuery();
			
			List<Customer> l1 = new ArrayList<Customer>(); 
			
			while( set.next()) {
				
				int id1 = set.getInt("customerId");
				String email1 = set.getString("customerEmail"); 
				
				Customer customer = new Customer(); 
				
				customer.setCustomerId(id1);
				customer.setCustomerEmail(email1);
				
				l1.add(customer); 
			}
			return l1 ; 
		}catch(SQLException e) {
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
	// Method for add Product 
	public void addProduct(Product product){
		
		Connection connection = null; 
		connection = JDBCConnection.getConnection(); 
		try {
			String insert = "insert into product values( ? , ? , ? , ? )" ; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(insert); 
			
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getProductPrice());
			preparedStatement.setString(4, product.getProductAvilable());
			
			preparedStatement.execute(); 
			
			System.out.println("Product data.....Inserted");
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Method for Update the Product 
	public void updateProduct( int id , String name , double price , String avilable ) {
		
		Connection connection = null ; 
		connection = JDBCConnection.getConnection();
		try {
			String update = "update product set productName = ? , productPrice = ? , productAvilable = ? where productId = ? "; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(update); 
			
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, avilable);
			preparedStatement.setInt(4, id);
			
			preparedStatement.execute();
			
			System.out.println("Data Updated \nProduct Name : "+name+"\nProduct Price : "+price+"\nProduct Avilabilty : "+avilable);
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Method for Update Product Price 
	public void updateProductPrice( int id , double price) {
		Connection connection = null ; 
		connection = JDBCConnection.getConnection();
		try {
			String update = "update product set productPrice = ? where productId = ? "; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(update); 
			
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, id);
			
			preparedStatement.execute();
			
			System.out.println("Data Updated \nProduct Price : "+price);
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void updateProductAvailable( int id , String available) {
		
		Connection connection = null ; 
		connection = JDBCConnection.getConnection();
		try {
			String update = "update product set productAvilable = ? where productId = ? "; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(update); 
			
			preparedStatement.setString(1, available);
			preparedStatement.setInt(2, id);
			
			preparedStatement.execute();
			
			System.out.println("Data Updated \nProduct Available : "+available);
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//Method for Delete the Product details 
	public void deleteProduct( int id ) {
		
		Connection connection = null ; 
		
		connection = JDBCConnection.getConnection();
		
		try {
			String delete = "delete from product where productId = ? "; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(delete); 
			
			preparedStatement.setInt(1,id); 
			
			preparedStatement.execute(); 
			
			System.out.println("Customer data deleted ");
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
	// Method For display Customer Details 
	public List<Customer> displayCustomer(){
	
		Connection connection = null ; 
		connection = JDBCConnection.getConnection(); 
		try {
			String select = "select * from customer" ; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(select); 
			
			List<Customer> l1 = new ArrayList<Customer>(); 
			
			ResultSet set = preparedStatement.executeQuery(); 
			
			while ( set.next()) {
				
				int id = set.getInt("customerId"); 
				String name = set.getString("customerName");
				String email = set.getString("customerEmail");
				long phone = set.getLong("customerPhone");
				int proid = set.getInt("productId"); 
				
				Customer customer = new Customer();
				Product product = new Product();
				
				customer.setCustomerId(id);
				customer.setCustomerName(name);
				customer.setCustomerEmail(email);
				customer.setCustomerPhone(phone);
				product.setProductId(proid);
				customer.setProduct(product);
				
				l1.add(customer);
			}
			return l1 ; 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null; 
	}
	// Method for Display the Product details 
	public List<Product> displayProduct(){
		
		Connection connection =null ; 
		connection = JDBCConnection.getConnection();
		
		try {
			String select = "select * from product"; 
			
			PreparedStatement preparedStatement = connection.prepareStatement(select); 
			
			List<Product> l1 = new ArrayList<Product>(); 
			
			ResultSet set = preparedStatement.executeQuery();
			
			while (set.next()) {
				
				int id = set.getInt("productId");
				String name = set.getString("productName");
				double price = set.getDouble("productPrice");
				String available = set.getString("productAvilable");
				
				Product product = new Product();
				
				product.setProductId(id);
				product.setProductName(name);
				product.setProductPrice(price);
				product.setProductAvilable(available);
				
				l1.add(product);
			}
			return l1 ;
		}catch(SQLException e) {
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
