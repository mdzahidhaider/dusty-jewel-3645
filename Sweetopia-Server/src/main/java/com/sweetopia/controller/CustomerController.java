package com.sweetopia.controller;

import java.util.List;

import com.sweetopia.dto.CustomerDTO;
import com.sweetopia.entity.Cart;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sweetopia.entity.Customer;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;
import com.sweetopia.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestParam("name") String name,@RequestParam("password") String password){
		Customer customer=new Customer();
		customer.setUserPassword(password);
		customer.setUserName(name);
		Cart cart=new Cart();
		customer.setCart(cart);
			System.out.println(name+" "+password);
			customerService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);

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
			 Customer customer = customerService.getCustomerById(customerId);
			 return ResponseEntity.ok(customer);
		 }
		 catch(CustomerNotFoundException e) {
			 return ResponseEntity.notFound().build();
		 }
	}
}
