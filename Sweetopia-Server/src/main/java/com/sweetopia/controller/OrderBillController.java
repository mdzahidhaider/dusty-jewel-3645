package com.sweetopia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;

import com.sweetopia.service.OrderBillService;

import jakarta.validation.Valid;

@RestController
public class OrderBillController {
	
	private OrderBillService orderbillservice;
	
	@PostMapping("/orderbill")
	public ResponseEntity<OrderBill> addOrderBill(@Valid @RequestBody OrderBill orderbill) throws OrderBillNotFoundException{
		
		OrderBill ordbill=orderbillservice.addOrderBill(orderbill);
		return new ResponseEntity<>(ordbill, HttpStatus.CREATED);
	}

}
