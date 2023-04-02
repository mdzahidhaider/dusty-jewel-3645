package com.sweetopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.Category;
import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Product;
import com.sweetopia.entity.User;
import com.sweetopia.exception.CategoryException;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.ProductException;
import com.sweetopia.exception.UserNotFoundException;
import com.sweetopia.service.AdminService;

@RestController
@RequestMapping("/sweetopia")
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/users")
	public ResponseEntity<List<User>> getListOfAllUsers() throws UserNotFoundException{
		List<User> users = adminService.allUsers();
		return new ResponseEntity<>(users,HttpStatus.FOUND);
		
		
	}
	@GetMapping("/admin/customers")
	public ResponseEntity<List<Customer>> getListOfAllCustomers() throws CustomerNotFoundException{
		List<Customer> customers = adminService.allCustomers();
		return new ResponseEntity<>(customers,HttpStatus.FOUND);
		
		
	}
	
	@GetMapping("/admin/products")
	public ResponseEntity<List<Product>> getListOfAllProducts() throws ProductException{
		List<Product> products = adminService.allProducts();
		return new ResponseEntity<>(products,HttpStatus.FOUND);
		
		
	}
	
	@GetMapping("/admin/categories")
	public ResponseEntity<List<Category>> getListOfAllCategories() throws CategoryException{
		List<Category> categories = adminService.allCategories();
		return new ResponseEntity<>(categories,HttpStatus.FOUND);
		
		
	}

}
