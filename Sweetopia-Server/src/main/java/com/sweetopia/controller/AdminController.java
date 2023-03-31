package com.sweetopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.Customer;
import com.sweetopia.entity.User;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.UserNotFoundException;
import com.sweetopia.service.AdminService;

@RestController
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/users")
	
	public ResponseEntity<List<User>> getListOfAllUsers() throws UserNotFoundException{
		List<User> users = adminService.allUsers();
		return new ResponseEntity<>(users,HttpStatus.FOUND);
		
		
	}
	
	public ResponseEntity<List<Customer>> getListOfAllCustomers() throws CustomerNotFoundException{
		List<Customer> customers = adminService.allCustomers();
		return new ResponseEntity<>(customers,HttpStatus.FOUND);
		
		
	}

}
