package com.sweetopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public Optional<Customer> findByEmailAndUserPassword(String userName,String userPassword);
	public Optional<Customer> findByEmail(String email);
	
}
