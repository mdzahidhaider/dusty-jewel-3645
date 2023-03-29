package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.User;

public interface UserService {
		
	public User addUser(User newUser);
	public List<User> getAllUser();
	public User updateUserDetails(User user);
	public String deleteUser(Long id);
	public String deleteAllUser();
	
}
