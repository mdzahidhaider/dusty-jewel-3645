package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer cudtomer);
	public Customer cancelCustomer(int CustomerId);
	public List<Customer> showAllCustomers();
	public List<Customer> showAllCustomers(int CustomerId);
}
