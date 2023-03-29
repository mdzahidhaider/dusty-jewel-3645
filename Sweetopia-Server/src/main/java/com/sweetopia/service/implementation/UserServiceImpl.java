package com.sweetopia.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.User;
import com.sweetopia.repository.UserRepository;
import com.sweetopia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User newUser) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserDetails(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
