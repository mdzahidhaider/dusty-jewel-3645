package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.User;
import com.sweetopia.exception.UserNotFoundException;
import com.sweetopia.repository.UserRepository;
import com.sweetopia.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User newUser) {
		// TODO Auto-generated method stub
		User savedUser = userRepository.save(newUser);
		
		return savedUser;
	}

	@Override
	public List<User> getAllUser() throws UserNotFoundException {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		if(users.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}else
		return users;
	}

	@Override
	public User updateUserDetails(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> opt = userRepository.findById(user.getId());
		if(opt.isEmpty()) {
			throw new UserNotFoundException();
		}else
			return userRepository.save(user);
		
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
