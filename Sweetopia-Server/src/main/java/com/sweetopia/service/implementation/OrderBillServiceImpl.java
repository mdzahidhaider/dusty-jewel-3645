package com.sweetopia.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sweetopia.dto.ProductDTO;
import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Order;
import com.sweetopia.service.CustomerService;
import com.sweetopia.service.OrderService;
import com.sweetopia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;
import com.sweetopia.exception.OrderNotFoundException;
import com.sweetopia.repository.OrderBillRepository;
import com.sweetopia.service.OrderBillService;

@Service
public class OrderBillServiceImpl implements OrderBillService {
	@Autowired
	private OrderBillRepository orderbillrepository;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@Override
	public OrderBill addOrderBill(Long orderId) throws OrderBillNotFoundException, OrderNotFoundException {
		// TODO Auto-generated method stub
		Order order=orderService.showAllSweetOrderById(orderId);
		if(order.getOrderBill()!=null)throw new OrderBillNotFoundException("Bill already exists for the given order");
		OrderBill orderBill = new OrderBill();
		for(ProductDTO product:order.getGroupedProducts()){
			orderBill.setTotalCost(orderBill.getTotalCost()+(product.getPrice()* product.getQuantity()));
		}
		orderBill.setSweetOrder(order);
		order.setOrderBill(orderBill);
		return orderbillrepository.save(orderBill);
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderbill1 = orderbillrepository.findById(orderbill.getOrderBillId());
		if(orderbill1.isPresent()) {
			orderbillrepository.save(orderbill);
			return orderbill1.get();
		}else {
			throw new OrderBillNotFoundException("Order bill with id " + orderbill.getOrderBillId() + " does not exist");
		}
		
		
	}

	@Override
	public OrderBill cancelOrderBill(Long orderBillId) throws OrderBillNotFoundException, OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderbill1 = orderbillrepository.findById(orderBillId);

		if(orderbill1.isPresent()) {
			OrderBill ordbill=orderbill1.get();
			Order order=orderService.showAllSweetOrderById(ordbill.getSweetOrder().getOrderId());
			order.setOrderBill(null);
			orderService.updateSweetOrder(order.getCustomer().getId(),order);
			ordbill.setSweetOrder(null);
			orderbillrepository.deleteById(orderBillId);
			return ordbill;
		}else {
			throw new OrderBillNotFoundException("Order bill with id " + orderBillId + " does not exist");
		}
		
	}

	@Override
	public List<OrderBill> showAllOrderBills() throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		List<OrderBill> bills = orderbillrepository.findAll();
		if(bills.isEmpty()) {
			throw new OrderBillNotFoundException("No order bill found!");
		}else {
			return bills;
		}
		
	}

	@Override
	public OrderBill showAllOrderBillsById(Long orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderbill1 = orderbillrepository.findById(orderBillId);
		if(orderbill1.isPresent()) {
			return orderbill1.get();
		}else {
			throw new OrderBillNotFoundException("Order bill with id " + orderBillId + " does not exist");
			
		}
		
		
	}

	@Override
	public List<OrderBill> showAllBillOfCustomer(Long customerId) throws OrderBillNotFoundException {
		Customer customer=customerService.getCustomerById(customerId);
		List<OrderBill> list = new ArrayList<>();
		for(Order order:customer.getOrders()){
			if(order.getOrderBill()!=null){
				list.add(order.getOrderBill());
			}
		}
		return list;
	}

}
