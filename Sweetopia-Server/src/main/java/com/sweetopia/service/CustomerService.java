package com.sweetopia.service;

import java.util.List;
import java.util.Optional;

import com.sweetopia.entity.Customer;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws InvalidCustomerException ;
	public Customer updateCustomer(Customer customer) throws InvalidCustomerException ;
	public Customer cancelCustomer(Long CustomerId) throws CustomerNotFoundException;
	public List<Customer> showAllCustomers();
	public Customer getCustomerById(Long CustomerId) throws CustomerNotFoundException;
}
