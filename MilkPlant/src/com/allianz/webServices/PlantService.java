package com.allianz.webServices;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.allianz.dto.OrderDto;
import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.serviceImplementation.OrderServiceImplementation;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.UserServiceImp;
import com.allianz.serviceInterface.OrderServiceInterface;
import com.allianz.serviceInterface.ProductServiceInterface;
import com.allianz.serviceInterface.UserServiceInterface;

/**
 * 
 * @author User
 *
 */
@Path("/PlantService")
public class PlantService 
{





	ProductServiceImplementation productImpl= new ProductServiceImplementation();
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * 
	 * @return the list of all products present
	 */
	public List<ProductDto> getAllProduct()
	{

		return  productImpl.getAllProduct();
	}//fetching all products ends

	/**
	 * 
	 */
	@GET
	@Path("/category/{category}")
	@Produces(MediaType.APPLICATION_JSON)

	public List<ProductDto> getProductByCategory(@PathParam("category") String category)
	{
		return  productImpl.getAllProducts(category);
	}

	/**
	 * 
	 * @param productName
	 * @param quantityToOrder
	 * @return
	 */
	@GET
	@Path("{productName}/availability/{quantityToOrder}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAvailability(@PathParam("productName") String productName,@PathParam("quantityToOrder") int quantityToOrder)
	{
		OrderServiceImplementation orderServiceImp= new OrderServiceImplementation();
		ProductServiceImplementation productService=new ProductServiceImplementation();
		ProductDto productDetail=productService.getProduct(productName);
		if(orderServiceImp.checkAvalibity(productDetail, quantityToOrder))
		{
			return "Stock available Please proceed further for ordering";
		}
		else
		{
			return "not available..you can go for othe product";
		}


	}//getAvailability ends	

/**
 * 
 * @param productName
 * @param quantityToOrder
 * @param customerId
 * @return
 */
	@GET
	@Path("/productName/{productName}/quantity/{quantityToOrder}/CustomerId/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderDto placeAnOrder(@PathParam("productName") String productName,@PathParam("quantityToOrder") int quantityToOrder,@PathParam("customerId") int customerId)
	{   System.out.println(productName);
	ProductServiceInterface productService=new ProductServiceImplementation();
	ProductDto product=productService.getProduct(productName);
	UserServiceInterface userService=new UserServiceImp();
	UserDto user=userService.getUserById(customerId);

	OrderDto order=new OrderDto(product, user, quantityToOrder);
	OrderServiceInterface orderService=new OrderServiceImplementation();
	orderService.placeOrder(order);
	orderService.stockAfterOrder(order, quantityToOrder);

	int orderOfId=orderService.getOrderID();

	OrderDto orderDetails=orderService.orderDetailsById(orderOfId-1);
	return orderDetails;



	}//getAvailability ends	


}


