package com.sweetopia.controller;

import java.util.List;

import com.sweetopia.dto.CustomerDTO;
import com.sweetopia.dto.CustomerLoginDTO;
import com.sweetopia.entity.Address;
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




@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO){
		Customer customer=new Customer();
		customer.setUserName(customerDTO.getUserName());
		customer.setUserPassword(customerDTO.getUserPassword());
		customer.setEmail(customerDTO.getEmail());
		Cart cart=new Cart();
		customer.setCart(cart);

			customerService.addCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId")Long customerId,@RequestBody Customer customer){

			customer.setId(customerId);
			customerService.updateCustomer(customer);
			return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> showAllCustomers(){
		
		List<Customer> customers = customerService.showAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> showCustomerById(@PathVariable("customerId")Long customerId) {

		Customer customer = customerService.getCustomerById(customerId);
		return ResponseEntity.ok(customer);
	}
	@GetMapping("/{customerId}/addresses")
	public ResponseEntity<List<Address>> getAlladdress(@PathVariable Long customerId){
		List<Address> address1=customerService.getAllAddressByCustomerId(customerId);
		return new ResponseEntity<>(address1,HttpStatus.OK);
	}
	@PostMapping("/{customerId}/addresses")
	public ResponseEntity<Address> addAddressToCustomer(@PathVariable Long customerId, @RequestBody Address address){
		Address address1=customerService.addAddressToCustomer(customerId,address);
		return new ResponseEntity<>(address1,HttpStatus.ACCEPTED);
	}
	@PutMapping("/{customerId}/addresses/{addressId}")
	public ResponseEntity<Address> addAddressToCustomer(@PathVariable Long customerId,@PathVariable Long addressId, @RequestBody Address address){
		Address address1=customerService.updateAddressOfCustomer(customerId,addressId,address);
		return new ResponseEntity<>(address1,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/{customerId}/addresses/{addressId}")
	public ResponseEntity<Address> deleteAddress(@PathVariable Long customerId,@PathVariable Long addressId){
		Address address1=customerService.deleteAddressOfCustomer(customerId,addressId);
		return new ResponseEntity<>(address1,HttpStatus.ACCEPTED);
	}
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody CustomerLoginDTO customerDTO){

		Customer customer=customerService.customerLogin(customerDTO.getEmail(),customerDTO.getUserPassword());
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
}
