package com.sweetopia.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sweetopia.dto.ProductDTO;
import com.sweetopia.entity.Cart;
import com.sweetopia.entity.Customer;
import com.sweetopia.exception.ProductException;
import com.sweetopia.repository.CustomerRepository;
import com.sweetopia.service.CartService;
import com.sweetopia.service.CustomerService;
import jakarta.transaction.Transactional;
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
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartService cartService;


	@Override
	public Order addSweetOrder(Long customerId,Order order) throws OrderNotFoundException, ProductException {
		// TODO Auto-generated method

		Customer customer =customerService.getCustomerById(customerId);
		List<ProductDTO> list=customer.getCart().getListProduct();
		System.out.println(list);
		if(list.isEmpty())throw new OrderNotFoundException("Cart is empty add product to cart");
		Order order1=new Order();
		order1.setCustomer(customer);
		for(ProductDTO p:customer.getCart().getListProduct()){
			order1.getGroupedProducts().add(p);
		}

		Cart cart=cartService.showAllCarts(customer.getCart().getCartId());
		cart.setGrandTotal(0.0);
		cart.setTotal(0.0);
		cart.setProductCount(0);
		cart.setListProduct(new ArrayList<>());
		cartService.updateCart(cart);

		return orderrepository.save(order1);
		 
	}

	@Override
	public Order updateSweetOrder(Long customerId,Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> ord;
		if(order.getOrderId()!=null) {
			Long id=order.getOrderId();
			if(orderrepository.findById(id).isEmpty())throw new OrderNotFoundException("Order not found");
			ord=orderrepository.findById(id);
		}else{
			throw new OrderNotFoundException("Order id cannot be null");
		}
		Customer customer =customerService.getCustomerById(customerId);
		boolean flag=false;
		for(Order order1:customer.getOrders()){
			if(order1.getOrderId()==order.getOrderId()){
				flag=true;
				break;
			}
		}
		if(flag){
			order.setCustomer(customer);
			return orderrepository.save(order);
		}else{
			throw new OrderNotFoundException("Order with id: "+order.getOrderId()+" does not belong to customer id: "+customerId);
		}


		
	}

	@Override
	public Order cancelSweetOrder(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> ord =orderrepository.findById(orderId);
		if(ord.isPresent()) {
			Order od=ord.get();
			od.setCustomer(null);
			orderrepository.deleteById(orderId);
			return ord.get();
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
	public Order showAllSweetOrderById(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> ord=orderrepository.findById(orderId);
		if(ord.isEmpty()) {
			throw new OrderNotFoundException("Order with id " + orderId + " does not exist");
		}else {
			return ord.get();
		}
		
		
	}

	@Override
	public double calculateTotalOrdercost(Long orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> orders = orderrepository.findById(orderId);
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("Order with id " + orderId + " does not exist");
        }
        return orders.get().getOrderBill().getTotalCost();
		
	}

}
