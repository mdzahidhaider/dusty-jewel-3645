package com.sweetopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer addCustomer(Customer customer);

	
}
