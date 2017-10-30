package com.allianz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.UserServiceImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
 
public class UserServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(UserServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("in userSrvlet");
		String action=request.getParameter("action");
		logger.info(action);
		if ( action!= null) 
		{
			if (action.equals("addClerkLink")){ 
				logger.info("in doGet of addClerkLink");
				addClerkServletLink(request,response);
			}
			else if (action.equals("addClerk")){ 
				logger.info(" action AddClerk");
				addClerk(request,response);
			}
	}
	}
	private void addClerkServletLink(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("in AddClerkServletLINK method");
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddAClerk.jsp");
		dispatcher.forward(request, response);
	}

	private void addClerk(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("in addclerkServlet method ");
		
		String userName= request.getParameter("uname");
		String userPassword=request.getParameter("pass");
		//
		String userType=request.getParameter("userType");
		String userAddress=request.getParameter("userAddress");
		String mobNo=request.getParameter("userMobile");
		int mobNumber=Integer.parseInt(mobNo);
		
		UserDto userDto= new UserDto(userName, userPassword, userType, userAddress, mobNumber);
		UserServiceImp userService= new UserServiceImp();
		userService.addUser(userDto);
		request.setAttribute("clerk", "Clerk");
	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AdminSucess.jsp");
	dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
