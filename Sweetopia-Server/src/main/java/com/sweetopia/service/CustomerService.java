package com.sweetopia.service;

import java.util.List;
import java.util.Optional;

import com.sweetopia.entity.Address;
import com.sweetopia.entity.Customer;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws InvalidCustomerException ;
	public Customer updateCustomer(Customer customer) throws InvalidCustomerException ;
	public Customer cancelCustomer(Long CustomerId) throws CustomerNotFoundException;
	public List<Customer> showAllCustomers();
	public Customer getCustomerById(Long CustomerId) throws CustomerNotFoundException;
	public Address addAddressToCustomer(Long CustomerId,Address address)throws CustomerNotFoundException;
	public Address updateAddressOfCustomer(Long CustomerId,Long addressId,Address address)throws CustomerNotFoundException;
	public Address deleteAddressOfCustomer(Long CustomerId,Long addressId)throws CustomerNotFoundException;
	public List<Address> getAllAddressByCustomerId(Long CustomerId)throws CustomerNotFoundException;
}
