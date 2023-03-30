package com.sweetopia.service.implementation;

import org.springframework.stereotype.Service;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;
import com.sweetopia.service.OrderBillService;

@Service
public class OrderBillServiceImpl implements OrderBillService {

	@Override
	public OrderBill addOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBill cancelOrderBill(Long orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBill showAllOrderBills() throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBill showAllOrderBillsById(Long orderBillId) throws OrderBillNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
