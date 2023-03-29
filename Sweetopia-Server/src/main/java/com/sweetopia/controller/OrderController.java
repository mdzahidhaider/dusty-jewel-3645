package com.sweetopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.Order;
import com.sweetopia.exception.OrderNotFoundException;
import com.sweetopia.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderNotFoundException{
		Order ord=orderservice.addSweetOrder(order);
		return new ResponseEntity<>(ord, HttpStatus.CREATED);
		
	}
	

}
