package com.sweetopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.User;
import com.sweetopia.exception.UserNotFoundException;
import com.sweetopia.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User addedUser = userService.addUser(user);
		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() throws UserNotFoundException{
		List<User> allUsers = userService.getAllUser();
		return new ResponseEntity<>(allUsers, HttpStatus.ACCEPTED);
	}
	
	
	
//	????????????
	@PatchMapping("/update/{id}")
	public ResponseEntity<User> updateUserDetails(@RequestBody User user, @PathVariable Long id) throws UserNotFoundException{
		
		user = entityManager.find(User.class, id);
		if(user!=null) {
			user.setUserName(user.getUserName());
			user.setUserPassword(user.getUserPassword());
			user.setUserType(user.getUserType());
			
			return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		
		}else
			throw new UserNotFoundException();
	
	}
	
//	???????????
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws UserNotFoundException{
		String userDeleted = userService.deleteUser(id);
		return new ResponseEntity<String>("User has been deletd "+ userDeleted, HttpStatus.OK);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteAllUser() {
		String allDeletedUser = userService.deleteAllUser();
//		String userDeleted = userService.deleteUser(id);
		return new ResponseEntity<String>("All users have been deletd "+ allDeletedUser, HttpStatus.OK);
	}
}	
