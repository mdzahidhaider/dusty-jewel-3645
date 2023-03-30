package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.Order;
import com.sweetopia.exception.OrderNotFoundException;
import com.sweetopia.repository.OrderRepository;
import com.sweetopia.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderrepository;

	@Override
	public Order addSweetOrder(Order order) throws OrderNotFoundException {
		// TODO Auto-generated method 
		Order ord = orderrepository.save(order);
		return ord;
	}

	@Override
	public Order updateSweetOrder(Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> ord=orderrepository.findById(order.getOrderId());
		if(ord.isPresent()) {
			orderrepository.save(order);
			return ord.get();
		}else {
			throw new OrderNotFoundException("Order Not Found With this id "+order.getOrderId());
		}
		
	}

	@Override
	public Order cancelSweetOrder(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showAllSweetOrder() throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showAllSweetOrderById(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalOrdercost(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
