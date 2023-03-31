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
			throw new UserNotFoundException();
		}else
		
		return userList;
	}

	@Override
	public List<Customer> allCustomers() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> allProducts() throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> allCategories() throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
