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
			throw new OrderNotFoundException("Order with id " + order.getOrderId() + " does not exist");
		}
		
	}

	@Override
	public Order cancelSweetOrder(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> ord =orderrepository.findById(orderId);
		if(ord.isPresent()) {
			Order od=ord.get();
			orderrepository.deleteById(orderId);
			return od;
		}else {
			throw new OrderNotFoundException("Order with id " + orderId + " does not exist");
		}
		
		
	}

	@Override
	public List<Order> showAllSweetOrder() throws OrderNotFoundException {
		// TODO Auto-generated method stub
		List<Order> ord=orderrepository.findAll();
		if(ord.isEmpty()) {
			throw new OrderNotFoundException("No Order Found !");
		}else {
			return ord;
		}
		
	}

	@Override
	public List<Order> showAllSweetOrderById(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		List<Order> ord=orderrepository.findByOrderId(orderId);
		if(ord.isEmpty()) {
			throw new OrderNotFoundException("Order with id " + orderId + " does not exist");
		}else {
			return ord;
		}
		
		
	}

	@Override
	public double calculateTotalOrdercost(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		List<Order> orders = orderrepository.findByOrderId(orderId);
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("Order with id " + orderId + " does not exist");
        }
        double totalCost = 0;
        for (Order order : orders) {
            totalCost += order.getOrderBill().getTotalCost();
        }
        return totalCost;
		
	}

}
