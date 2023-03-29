package com.sweetopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.User;
import com.sweetopia.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User addedUser = userService.addUser(user);
		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
	}

}
