/**
 * 
 */
package com.allianz.serviceInterface;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.allianz.dto.OrderDto;
import com.allianz.dto.ProductDto;
import com.allianz.dto.StockDto;


/**
 * @author User
 *
 */
public interface OrderServiceInterface {
	public Boolean checkAvalibity(ProductDto product ,int Quantity);
	public OrderDto placeOrder(OrderDto order) ;
	public OrderDto orderDetailsById(int orderId);
	public int getOrderID();
	public Boolean stockAfterOrder(OrderDto order,int quantity);

}
