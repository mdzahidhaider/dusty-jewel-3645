package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import com.sweetopia.entity.Address;
import com.sweetopia.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Order;

import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.exception.InvalidCustomerException;
import com.sweetopia.repository.CustomerRepository;
import com.sweetopia.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired(required = false)
	private CustomerRepository customerRepository;
	@Autowired(required = false)
	private AddressRepository addressRepository;

	@Override
	public Customer addCustomer(Customer customer)throws InvalidCustomerException {
		Optional<Customer> customer2 =customerRepository.findByEmail(customer.getEmail());
		if(customer2.isPresent())throw new InvalidCustomerException(customer.getEmail()+" email already registered!");
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

	@Override
	public Address addAddressToCustomer(Long CustomerId, Address address) throws CustomerNotFoundException {
		Customer customer=getCustomerById(CustomerId);
		address.setCustomer(customer);
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddressOfCustomer(Long CustomerId, Long addressId, Address address) throws CustomerNotFoundException {
		Customer customer=getCustomerById(CustomerId);
		boolean flag=false;
		for(Address address1:customer.getAddresses()){
			if(addressId==address1.getAddId()){
				flag=true;
				address.setAddId(addressId);
				customer.getAddresses().remove(address1);
				customer.getAddresses().add(address);
				break;
			}
		}
		if(!flag)throw new CustomerNotFoundException("No address found for customer");

		updateCustomer(customer);
		return address;
	}

	@Override
	public Address deleteAddressOfCustomer(Long CustomerId, Long addressId) throws CustomerNotFoundException {
		Customer customer=getCustomerById(CustomerId);
		boolean flag=false;
		Address address=null;
		for(Address address1:customer.getAddresses()){
			if(addressId==address1.getAddId()){
				flag=true;
				address=address1;
				customer.getAddresses().remove(address1);
				break;
			}
		}
		if(!flag)throw new CustomerNotFoundException("No address found for customer");
		address.setCustomer(null);
		addressRepository.delete(address);
		return address;
	}

	@Override
	public List<Address> getAllAddressByCustomerId(Long CustomerId) throws CustomerNotFoundException {
		Customer customer=getCustomerById(CustomerId);
		List<Address> list=customer.getAddresses();
		if(list.isEmpty())throw new CustomerNotFoundException("No address present for the given customer");

		return list;
	}

	@Override
	public Customer customerLogin(String email, String password) throws CustomerNotFoundException {
		Optional<Customer> customer=customerRepository.findByEmailAndUserPassword(email,password);
		if(customer.isEmpty())throw new CustomerNotFoundException("Invalid credentials");
		return customer.get();
	}

}