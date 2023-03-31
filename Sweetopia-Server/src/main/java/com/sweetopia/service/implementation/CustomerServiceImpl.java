package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Order;
import com.sweetopia.entity.User;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;
import com.sweetopia.repository.CustomerRepository;
import com.sweetopia.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer)throws InvalidCustomerException {

		if (customer.getId() != null) {
			if(customerRepository.findById(customer.getId()).isPresent())throw new InvalidCustomerException("User with id:"+customer.getId()+" already present");
		}
		return customerRepository.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) throws InvalidCustomerException{

		if (customer.getId() != null) {
			if(customerRepository.findById(customer.getId()).isEmpty())throw new InvalidCustomerException("User with id:"+customer.getId()+" not found");
		}else{
			throw new InvalidCustomerException("No customer id mentioned");
		}


		return customerRepository.save(customer);
	}

	@Override
	public Customer cancelCustomer(Long CustomerId)throws CustomerNotFoundException {

		Customer existingCustomer = customerRepository.findById(CustomerId).orElseThrow(()-> new CustomerNotFoundException("Customer not fouund with this id :"+CustomerId));
		customerRepository.deleteById(CustomerId);
		return existingCustomer;
	}

	@Override
	public List<Customer> showAllCustomers() throws InvalidCustomerException{
		List<Customer> list= customerRepository.findAll();
		if(list.isEmpty())throw new InvalidCustomerException("No customer in database");
		return list;
	}

	@Override
	public Customer getCustomerById(Long CustomerId)throws CustomerNotFoundException {
		Optional<Customer> customerOption=customerRepository.findById(CustomerId);
		if(customerOption.isEmpty())throw new CustomerNotFoundException("No customer found with id : "+CustomerId);


		return customerOption.get();


	}

}