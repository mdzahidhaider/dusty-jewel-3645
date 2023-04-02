package com.sweetopia.controller;

import java.util.List;

import com.sweetopia.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;

import com.sweetopia.service.OrderBillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sweetopia/orderbill")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderBillController {
	
	@Autowired
	private OrderBillService orderbillservice;
	
	@PostMapping("/{orderId}/orderbill")
	public ResponseEntity<OrderBill> addOrderBill(@PathVariable Long orderId) throws OrderBillNotFoundException, OrderNotFoundException {
		
		OrderBill ordbill = orderbillservice.addOrderBill(orderId);
		return new ResponseEntity<>(ordbill, HttpStatus.CREATED);
	}
	
	@PutMapping("/orderbills")
	public ResponseEntity<OrderBill> updateOrderBill(@Valid @RequestBody OrderBill orderbill) throws OrderBillNotFoundException{
		OrderBill ordbill = orderbillservice.updateOrderBill(orderbill);
		return new ResponseEntity<>(ordbill, HttpStatus.OK);
	}
	
	@DeleteMapping("/orderbills/{orderBillId}")
	public ResponseEntity<OrderBill> cancelOrderBill(@PathVariable Long orderBillId) throws OrderBillNotFoundException, OrderNotFoundException {
		OrderBill ordbill = orderbillservice.cancelOrderBill(orderBillId);
		return new ResponseEntity<>(ordbill, HttpStatus.OK);
	}
	
	@GetMapping("/orderbills")
	public ResponseEntity<List<OrderBill>> showAllOrderBills() throws OrderBillNotFoundException{
		List<OrderBill> orderbill = orderbillservice.showAllOrderBills();
		return new ResponseEntity<>(orderbill, HttpStatus.OK);
		
	}
	
	@GetMapping("/orderbills/{orderBillId}")
	public ResponseEntity<OrderBill> showAllOrderBillsById(@PathVariable Long orderBillId) throws OrderBillNotFoundException {
		OrderBill ordbill = orderbillservice.showAllOrderBillsById(orderBillId);
		return new ResponseEntity<>(ordbill, HttpStatus.OK);
	}
	
	@GetMapping("/orderbills/{customerId}")
	public ResponseEntity<List<OrderBill>> showAllBillOfCustomer(@PathVariable Long customerId) throws OrderBillNotFoundException{
		List<OrderBill> ordbill = orderbillservice.showAllBillOfCustomer(customerId);
		return new ResponseEntity<>(ordbill, HttpStatus.OK);
	}

}
