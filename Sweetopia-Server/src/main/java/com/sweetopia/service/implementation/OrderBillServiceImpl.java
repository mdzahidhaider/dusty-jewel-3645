package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;
import com.sweetopia.repository.OrderBillRepository;
import com.sweetopia.service.OrderBillService;

@Service
public class OrderBillServiceImpl implements OrderBillService {
	
	private OrderBillRepository orderbillrepository;

	@Override
	public OrderBill addOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		OrderBill ordbill=orderbillrepository.save(orderbill);
		
		return orderbill;
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		 Optional<OrderBill> orderb= orderbillrepository.findById(orderbill.getOrderBillId());
		 if(orderb.isPresent()) {
			 orderbillrepository.save(orderbill);
			 return orderb.get();
			 
		 }else {
			 throw new OrderBillNotFoundException("Order Bill  not found with id "+orderbill.getOrderBillId());
		 }
		
	}

	@Override
	public OrderBill cancelOrderBill(Integer orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderb= orderbillrepository.findById(orderBillId);
		if(orderb.isPresent()) {
			OrderBill orderbill=orderb.get();
			orderbillrepository.deleteById(orderBillId);
			return orderbill;
		}else {
			throw new OrderBillNotFoundException("Order Bill  not found with id "+orderBillId);
		}
		
		
	}

	@Override
	public List<OrderBill> showAllOrderBills() throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		List<OrderBill> orderbills=orderbillrepository.findAll();
		if(orderbills.isEmpty()) {
			throw new OrderBillNotFoundException("No Order Bills found ");
		}else {
			return orderbills;
		}
	}

	@Override
	public OrderBill showAllOrderBillsById(Integer orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderb = orderbillrepository.findById(orderBillId);
		if(orderb.isPresent()) {
			return orderb.get();
		}else {
			throw new OrderBillNotFoundException("Order Bill  not found with id "+orderBillId);
		}
		
	
	}

}
