package com.sweetopia.service;

import com.sweetopia.entity.OrderBill;
import com.sweetopia.exception.OrderBillNotFoundException;

public interface OrderBillService {
	
	
	//method add order bill 
	public OrderBill addOrderBill(OrderBill orderbill) throws OrderBillNotFoundException;
	
	//method for update order bill
	public OrderBill updateOrderBill(OrderBill orderbill) throws OrderBillNotFoundException;
	
	//method for cancel order bill
	public OrderBill cancelOrderBill(Integer orderBillId) throws OrderBillNotFoundException;
	
	//method for show All order bills
	public OrderBill showAllOrderBills() throws OrderBillNotFoundException;
	
	//method for show All order bill
	public OrderBill showAllOrderBillsById(Integer orderBillId) throws OrderBillNotFoundException;

}
