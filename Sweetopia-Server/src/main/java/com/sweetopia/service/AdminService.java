package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Category;
import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Product;
import com.sweetopia.entity.User;
import com.sweetopia.exception.CategoryException;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.ProductException;
import com.sweetopia.exception.UserNotFoundException;

public interface AdminService {
	
//	List of all
	
	List<User> allUsers() throws UserNotFoundException;
	List<Customer> allCustomers() throws CustomerNotFoundException;
	List<Product> allProducts()throws ProductException;
	List<Category> allCategories() throws CategoryException;
	
//	Delete all
	
	
	
	
	
	
	

	
}
