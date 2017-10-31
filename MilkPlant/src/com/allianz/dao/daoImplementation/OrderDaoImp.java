package com.allianz.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoInterface.OrderDaoInterface;
import com.allianz.dao.daoInterface.UserDaoInterface;
import com.allianz.dto.OrderDto;
import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.UserServiceImp;
import com.allianz.serviceInterface.ProductServiceInterface;
import com.allianz.serviceInterface.UserServiceInterface;
import com.allianz.servlet.StockServlet;


/**
 * @author User
 *
 */
public class OrderDaoImp implements OrderDaoInterface {
	private static final Logger logger=Logger.getLogger(OrderDaoImp.class);


	/**
	 * doing connection
	 */
	Connection	connection=DbConnection.getConnection();

	/**
	 *query for adding stock
	 */
	static String addStockQuery=
			"insert into " + OrderDto.TABLENAME +"("+OrderDto.PRODUCTNAME+","+OrderDto.USERID+
			","+OrderDto.NUMBEROFPRODUCT+","+OrderDto.TOTALPRICE+
			")" +" values(?,?,?,?)";

	/**
	 * query for fetching the product by its id
	 */
	public static String getProductQuery="select * from "+OrderDto.TABLENAME +" where " + OrderDto.ORDERID+"=? ";
	/**
	 * fetching all the products present in stock
	 */

	public static String getAllStockQuery="select *from "+OrderDto.TABLENAME;
	/**
	 * method to add an order to the stock
	 */

	public OrderDto addOrder(OrderDto order) {
		try {
			PreparedStatement statement = connection.prepareStatement(addStockQuery);
			//logger.info(order.getTotalPrice());
			logger.info(order.getNumberOfProduct());
			logger.info(order.getProductName().getProductName());
			logger.info(order.getUserId().getUserId());
			statement.setString(1,order.getProductName().getProductName());
			statement.setInt(2,order.getUserId().getUserId());
			statement.setInt(3,order.getNumberOfProduct());
			statement.setInt(4,order.getTotalPrice());



			logger.info("before execute update");
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated==0)
				return null;

		}//try ends
		catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}//catch ends
		return order;	

	}//add order ends


	/**
	 * fetching the details of the order by its id
	 */

	public OrderDto detailsByOrderId(int orderid) {
		// TODO Auto-generated method stub
		int orderId;
		ProductDto productName;
		String productsName;
		UserDto userId;
		int idOfUser;
		int numberOfProduct;
		int totalPrice;
		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getProductQuery);
			prepareStatement.setInt(1, orderid);
			ResultSet resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				orderid =resultSet.getInt(1);
				productsName=resultSet.getString(2);
				idOfUser=resultSet.getInt(3);
				numberOfProduct=resultSet.getInt(4);
				totalPrice=resultSet.getInt(5);
				ProductServiceInterface productService=new ProductServiceImplementation();
				productName=productService.getProduct(productsName);
				UserServiceInterface userService=new UserServiceImp();
				userId=userService.getUserById(idOfUser);




				return new OrderDto(orderid, productName, userId, numberOfProduct, totalPrice);
			}//if ends
		}//try ends
		catch(Exception e)
		{
			logger.error(e);
		}//catch ends
		return null;
	}//detailsByOrderId ends


	/**
	 * fetching the list of orders
	 */
	public List<OrderDto> listOfOrder() {

		int orderId;
		ProductDto productName;
		String nameOfProduct;
		UserDto userId;
		int IdOfUser;
		int numberOfProduct;int totalPrice;

		List<OrderDto> listOfOrder= new ArrayList<OrderDto>();//for storing the details of all products
		try
		{
			PreparedStatement prepareStatement= connection.prepareStatement(getAllStockQuery);
			ResultSet resultSet= prepareStatement.executeQuery();
			while(resultSet.next())
			{
				orderId = resultSet.getInt(1);
				nameOfProduct= resultSet.getString(2);
				IdOfUser= resultSet.getInt(3);
				numberOfProduct=resultSet.getInt(4);
				totalPrice=resultSet.getInt(5);
				ProductDao product=new ProductDao();
				productName=product.getProduct(nameOfProduct);
				UserDaoInterface userDao=new UserDaoImp();
				userId=userDao.userDetailById(IdOfUser);
				OrderDto order=new OrderDto(orderId, productName, userId, numberOfProduct, totalPrice);

				listOfOrder.add(order);

			}//while ends
		}//try ends
		catch (Exception r)
		{
			logger.error(r);
		}//catch ends
		return listOfOrder;
	}//listOfOrder ends

}//class ends
