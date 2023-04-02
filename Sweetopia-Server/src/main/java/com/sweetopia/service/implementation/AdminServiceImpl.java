package com.sweetopia.service.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.Admin;
import com.sweetopia.entity.Customer;
import com.sweetopia.exception.AdminNotFoundException;
import com.sweetopia.exception.CustomerNotFoundException;
import com.sweetopia.repository.AdminRepository;
import com.sweetopia.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin adminLogin(String email, String password) throws AdminNotFoundException {
		Optional<Admin> admin=adminRepository.findByEmailAndUserPassword(email, password);
		if(admin.isEmpty())throw new AdminNotFoundException("Invalid credentials");
		return admin.get();
	}

}
