package com.allianz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dto.ProductDto;
import com.allianz.dto.StockDto;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.StockServiceImplementation;
import com.allianz.serviceInterface.ProductServiceInterface;
import com.allianz.serviceInterface.StockServiceInterface;


/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(StockServlet.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		logger.info(action);
		if(action!=null){
				if (action.equals("addStocklink"))
					addStocklink(request,response);
				
				if (action.equals("addstock"))
					addstock(request,response);
				if (action.equals("updateStocklink"))
					updateStocklink(request,response);
				if (action.equals("updateStock"))
					updateStock(request,response);
				
		}
				/*if(request.getParameter("addstock")!=null){
					logger.info("hdskjghj");
				}*/
				
			}

			private void updateStock(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				String productName=request.getParameter("product");
				int quantity=Integer.parseInt( request.getParameter("quantity"));
				logger.info("*************product aname**************");
				logger.info(productName);
				StockServiceInterface stockService=new StockServiceImplementation();
				StockDto stock=stockService.stockByName(productName);
				stockService.updateStockInfo(stock, quantity);
				
				// TODO Auto-generated method stub
				request.setAttribute("updateStock","updated the stock ..");

				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ClerkSucess.jsp");				logger.info("after forwardi ng");
				dispatcher.forward(request, response);
				
			}

			private void updateStocklink(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/UpdateStock.jsp");
				logger.info("after forwardi ng");
				dispatcher.forward(request, response);
				
				// TODO Auto-generated method stub
				
			}

			private void addstock(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				logger.info("i am in add stock **********************");
				// TODO Auto-generated method stub
				String productName=request.getParameter("Pname");
				int stockQuantity=Integer.parseInt(request.getParameter("Pquantity"));
				//**************************************************
			ProductDao productdao=new ProductDao();
				ProductDto product=productdao.getProduct(productName);
				StockServiceInterface stock=new StockServiceImplementation();
				StockDto stockdto=new StockDto(product, stockQuantity);
				logger.info("calling add stock info");
			Boolean count=stock.addStockInfo(stockdto);
			
			logger.info(count);

				if(count==true)
				{
					request.setAttribute("addStock","added the stock ..");

					RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ClerkSucess.jsp");
				}
				//*********************************************************
				else
				{ logger.info("i am in else");
					
				addStocklink(request,response);
				}
				
			}

			private void addStocklink(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				ProductServiceInterface stockService=new ProductServiceImplementation();
				List<String> listOfproduct=stockService.listOfProductName();
				request.setAttribute("listOfProduct", listOfproduct);
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddStock.jsp");
				logger.info("after forwarding");
				dispatcher.forward(request, response);
				
			}

			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
