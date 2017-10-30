package com.allianz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dao.daoInterface.ProductDaoInterface;
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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(OrderServlet.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if ( action!= null) 
		{
			if (action.equals("CheckAvailability")){ 
				checkAvailability(request,response);
				
				
			}
			else if(action.equals("PlaceOrder"))
			{
				generateBill(request,response);
			}
		
		}
		
	}

	private void generateBill(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderId=Integer.parseInt(request.getParameter("orderid"));
		logger.info(orderId);
		String productName=request.getParameter("productName");
		logger.info(productName);
	Integer userId=Integer.parseInt(request.getParameter("userId"));
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		//***********************************************
		  ProductServiceInterface productService=new ProductServiceImplementation();
		  ProductDto product=productService.getProduct(productName);
		  UserServiceInterface userService=new UserServiceImp();
		  UserDto user=userService.getUserById(userId);
		
		//*********************************************************
		OrderDto order=new OrderDto(product, user, quantity);
		OrderServiceInterface orderService=new OrderServiceImplementation();
		orderService.placeOrder(order);
		orderService.stockAfterOrder(order, quantity);
		OrderDto orderDetail=orderService.orderDetailsById(orderId);
		request.setAttribute("orderDetails", orderDetail);
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Bill.jsp");
		dispatcher.forward(request, response);
		
	}

	private void checkAvailability(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String productName=request.getParameter("ProductNames");
		String noOfPockets=request.getParameter("Enter the packets to be oredered");
		int pockets=Integer.parseInt(noOfPockets);
		ProductDaoInterface productDao=new ProductDao();
		ProductDto  product=productDao.getProduct(productName);
		
		OrderServiceInterface orderService=new OrderServiceImplementation();
		Boolean status=orderService.checkAvalibity(product, pockets);
		if(status)
		{   
		  int orderId=orderService.getOrderID();
		  String s=String.valueOf(orderId);
			logger.info("in true of status");
			logger.info("order id" +orderId);
            request.setAttribute("idOfOrder", orderId);
			request.setAttribute("ProductNames", productName);
			request.setAttribute("Enter the packets to be oredered",noOfPockets );
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Order.jsp");
			dispatcher.forward(request, response);	
		}
		else
		{
			logger.info("in false of status");
			request.setAttribute("notAvail", "Quantity not avaliable ! please select other...");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/SaleAProduct.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
