package com.sweetopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.Customer;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;
import com.sweetopia.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		try {
			customerService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		}
		catch(InvalidCustomerException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId")Long customerId,@RequestBody Customer customer){
		try {
			customer.setId(customerId);
			customerService.updateCustomer(customer);
			return ResponseEntity.ok().build();
		}
		catch(CustomerNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> showAllCustomers(){
		
		List<Customer> customers = customerService.showAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> showCustomerById(@PathVariable("customerId")Long customerId){
		 try {
			 Customer customer = customerService.showAllCustomers(customerId).get();
			 return ResponseEntity.ok(customer);
		 }
		 catch(CustomerNotFoundException e) {
			 return ResponseEntity.notFound().build();
		 }
	}
}
