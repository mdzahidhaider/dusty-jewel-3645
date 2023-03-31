package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;
import com.sweetopia.exception.OrderNotFoundException;

public interface OrderBillService {
	
	
	//method add order bill 
	public OrderBill addOrderBill(Long OrderId) throws OrderBillNotFoundException, OrderNotFoundException;
	
	//method for update order bill
	public OrderBill updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException;
	
	//method for cancel order bill
	public OrderBill cancelOrderBill(Long orderBillId) throws OrderBillNotFoundException, OrderNotFoundException;
	
	//method for show All order bills
	public List<OrderBill> showAllOrderBills() throws OrderBillNotFoundException;
	
	//method for show All order bill
	public OrderBill showAllOrderBillsById(Long orderBillId) throws OrderBillNotFoundException;

	public List<OrderBill> showAllBillOfCustomer(Long customerId)throws OrderBillNotFoundException;

}
