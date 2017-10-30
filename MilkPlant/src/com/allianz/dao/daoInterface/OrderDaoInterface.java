package com.allianz.dao.daoInterface;

import java.util.List;

import com.allianz.dto.OrderDto;


public interface OrderDaoInterface {
	public OrderDto addOrder(OrderDto order);
	public OrderDto detailsByOrderId(int orderId);
	public List<OrderDto> listOfOrder();
	
	

}
