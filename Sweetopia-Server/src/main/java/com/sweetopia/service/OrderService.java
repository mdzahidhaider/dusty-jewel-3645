package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Order;
import com.sweetopia.exception.OrderNotFoundException;

public interface OrderService {
	
	public Order addSweetOrder(Order order) throws OrderNotFoundException;
	
	public Order updateSweetOrder(Order order) throws OrderNotFoundException;
	
	public Order cancelSweetOrder(Integer orderId) throws OrderNotFoundException;
	
	public List<Order> showAllSweetOrder() throws OrderNotFoundException;
	
	
	public Order showAllSweetOrderById(Integer orderId) throws OrderNotFoundException;
	
	public double calculateTotalOrdercost(Integer orderId) throws OrderNotFoundException;
	

}
