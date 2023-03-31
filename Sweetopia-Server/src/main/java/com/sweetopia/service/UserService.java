package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.User;
import com.sweetopia.exception.UserNotFoundException;

public interface UserService {
		
	public User addUser(User newUser) throws UserNotFoundException;
	public List<User> getAllUser() throws UserNotFoundException;
	public User updateUserDetails(User user) throws UserNotFoundException;
	public String deleteUser(Long id) throws UserNotFoundException;
	public String deleteAllUser();
	
}
