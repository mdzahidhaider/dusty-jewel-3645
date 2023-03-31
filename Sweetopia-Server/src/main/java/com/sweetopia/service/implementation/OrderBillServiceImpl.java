package com.sweetopia.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;
import com.sweetopia.exception.OrderNotFoundException;
import com.sweetopia.repository.OrderBillRepository;
import com.sweetopia.service.OrderBillService;

@Service
public class OrderBillServiceImpl implements OrderBillService {
	
	private OrderBillRepository orderbillrepository;

	@Override
	public OrderBill addOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		if(orderbill.getOrderBillId()!=null) {
			Long id=orderbill.getOrderBillId();
			if(orderbillrepository.findById(id).isPresent())throw new OrderBillNotFoundException("Order Bill already present");
		}
		return orderbillrepository.save(orderbill);
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
	public OrderBill cancelOrderBill(Long orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderbill1 = orderbillrepository.findById(orderBillId);
		if(orderbill1.isPresent()) {
			OrderBill ordbill=orderbill1.get();
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

}
