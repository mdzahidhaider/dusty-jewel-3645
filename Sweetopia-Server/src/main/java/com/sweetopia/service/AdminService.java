package com.sweetopia.service;



import com.sweetopia.entity.Admin;

import com.sweetopia.exception.AdminNotFoundException;

public interface AdminService {

	public Admin adminLogin(String email, String password) throws AdminNotFoundException;
		
	
}
