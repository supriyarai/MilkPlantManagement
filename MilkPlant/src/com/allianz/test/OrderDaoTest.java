/**
 * 
 */
package com.allianz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.allianz.dao.daoImplementation.OrderDaoImp;
import com.allianz.dto.OrderDto;
import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.UserServiceImp;

/**
 * @author User
 *
 */
public class OrderDaoTest {

	ProductServiceImplementation productService= new ProductServiceImplementation();
	OrderDaoImp orderServiceImp= new OrderDaoImp();
	@Test
	public void addOrderTest()
	{
		
		UserServiceImp userService= new UserServiceImp();
	ProductDto product=	productService.getProduct("1 litre milk");
	UserDto user= userService.getUserById(200);
		//OrderDto orderDto= new OrderDto( product, user, 2);
		OrderDto orderDto= new OrderDto(product, user, 3);
		
	OrderDto order=	orderServiceImp.addOrder(orderDto);
String actualName=	order.getProductName().getProductName();
String expectedProductName=product.getProductName();
assertEquals(expectedProductName,actualName );
		
		
	}//addOrderTest ends
	@Test
	public void detailsByOrderIdTest()
	{
		int expectedId=300;
	OrderDto orderObj=	orderServiceImp.detailsByOrderId(300);
	assertEquals(expectedId, orderObj.getOrderId());
		
	}//detailsByorderId ends
	

}
