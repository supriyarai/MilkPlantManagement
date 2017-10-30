/**
 * 
 */
package com.allianz.serviceImplementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.OrderDaoImp;
import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dao.daoInterface.OrderDaoInterface;
import com.allianz.dao.daoInterface.ProductDaoInterface;
import com.allianz.dto.OrderDto;
import com.allianz.dto.ProductDto;
import com.allianz.dto.StockDto;
import com.allianz.serviceInterface.OrderServiceInterface;
import com.allianz.serviceInterface.StockServiceInterface;
import com.allianz.servlet.StockServlet;





/**
 * @author User
 *
 */
public class OrderServiceImplementation implements OrderServiceInterface {

	private static final Logger logger=Logger.getLogger(OrderServiceImplementation.class);


	public OrderDto placeOrder(OrderDto order) {
        OrderDaoInterface orderdao=new OrderDaoImp();
        ProductDaoInterface productDao=new ProductDao();
        ProductDto product=productDao.getProduct(order.getProductName().getProductName());
        int price=product.getProductPrice();
        int totalPrice=price*order.getNumberOfProduct();
        OrderDto newOrder=new OrderDto(order.getProductName(),order.getUserId(),order.getNumberOfProduct(), totalPrice);
        orderdao.addOrder(newOrder);
		return newOrder;
	}

	public OrderDto orderDetailsById(int orderId) {
        OrderDaoInterface orderService=new OrderDaoImp();
        OrderDto order=orderService.detailsByOrderId(orderId);
		return order;
	}

	public Boolean checkAvalibity(ProductDto product, int quantityToOrder) {
		StockServiceInterface stockService=new StockServiceImplementation();
		StockDto stockDto=stockService.stockByName(product.getProductName());
		int totalQuantity=stockDto.getStockTotalNumber();
         logger.info("******************************************");
		logger.info(totalQuantity);
		logger.info(quantityToOrder);
		if((quantityToOrder>totalQuantity) || (quantityToOrder<=0) )
		{ 
			return false;
		}
		return true;
	}

	public int getOrderID() {
		// TODO Auto-generated method stub
		OrderDaoInterface orderDto=new OrderDaoImp();
		int orderId = 0;
		List<OrderDto> listOrder=orderDto.listOfOrder();
		for (OrderDto orderDto2 : listOrder) {
			orderId=orderDto2.getOrderId();
			logger.info("orderId******************"+orderId);
		}
		return orderId+1;
	}

	public Boolean stockAfterOrder(OrderDto order,int quantity) {
		// TODO Auto-generated method stub
		StockServiceInterface stockService=new StockServiceImplementation();
		StockDto stock=stockService.stockByName(order.getProductName().getProductName());
	Boolean status=stockService.stockAfterOrder(stock, quantity);
		return status;
	}

}
