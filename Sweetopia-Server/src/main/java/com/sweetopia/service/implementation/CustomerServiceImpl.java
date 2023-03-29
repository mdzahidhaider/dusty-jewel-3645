package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Order;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;
import com.sweetopia.repository.CustomerRepository;
import com.sweetopia.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer)throws InvalidCustomerException {
		
		ValidateCustomer(customer);
		return customerRepository.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws InvalidCustomerException{
		
		ValidateCustomer(customer);
		
		Customer existingCustomer = customerRepository.findById(customer.getUserId()).orElseThrow(()-> new CustomerNotFoundException("customer not found with this id : "+customer.getUserId()));
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setSweetOrders(customer.getSweetOrders());
		existingCustomer.setCart(customer.getCart());
		
		return customerRepository.saveAndFlush(existingCustomer);
	}

	@Override
	public Customer cancelCustomer(Long CustomerId)throws CustomerNotFoundException {
		
		Customer existingCustomer = customerRepository.findById(CustomerId).orElseThrow(()-> new CustomerNotFoundException("Customer not fouund with this id :"+CustomerId));
		customerRepository.deleteById(CustomerId);
		return existingCustomer;
	}

	@Override
	public List<Customer> showAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> showAllCustomers(Long CustomerId)throws CustomerNotFoundException {
		
		
			return customerRepository.findById(CustomerId);
		
		
	}

	private void ValidateCustomer(Customer customer)throws InvalidCustomerException{
		
		if(customer == null) {
			throw new InvalidCustomerException("Customer can not be null");
		}
		
		if(customer.getUsername()== null || customer.getUsername().isEmpty()) {
			throw new InvalidCustomerException("Customer username can not be null or empty ");
		}
		
		if(customer.getSweetOrders()== null || customer.getSweetOrders().isEmpty()) {
			throw new InvalidCustomerException("Customer must have at least one sweet order");
		}
		
		for(Order order: customer.getSweetOrders()) {
			if(order.getProducts()== null || order.getProducts().isEmpty()) {
				throw new InvalidCustomerException("Sweet order must have at least one product");
			}
		}
	}
}
