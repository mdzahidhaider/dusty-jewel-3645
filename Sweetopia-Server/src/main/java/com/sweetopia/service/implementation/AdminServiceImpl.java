package com.sweetopia.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.Category;
import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Product;
import com.sweetopia.entity.User;
import com.sweetopia.exception.CategoryException;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.ProductException;
//
//import com.sweetopia.repository.UserRepositoryxception;
import com.sweetopia.exception.UserNotFoundException;
import com.sweetopia.repository.CategoryRepository;
import com.sweetopia.repository.CustomerRepository;
import com.sweetopia.repository.ProductRepository;
import com.sweetopia.repository.UserRepository;
import com.sweetopia.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<User> allUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> userList = userRepository.findAll();
		if(userList.isEmpty()) {
			throw new UserNotFoundException("No user found");
		}else
		
		return userList;
	}

	@Override
	public List<Customer> allCustomers() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerRepository.findAll();
		if(customerList.isEmpty()) {
			throw new CustomerNotFoundException("No customer found");
		}else
		
		return customerList;
	}

	@Override
	public List<Product> allProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findAll();
		if(productList.isEmpty()) {
			throw new ProductException("No product found");
		}else
		
		return productList;
	}

	@Override
	public List<Category> allCategories() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> categoryList = categoryRepository.findAll();
		if(categoryList.isEmpty()) {
			throw new CategoryException("No category found");
		}else
		
		return categoryList;
	}

}
