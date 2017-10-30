package com.allianz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.UserDaoImp;
import com.allianz.dto.UserDto;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(LogInServlet.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDto aUser;
		logger.info("entering in doPost");
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String user=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		
		
		UserDaoImp userDao=new UserDaoImp();
		List<UserDto> users=	userDao.getAllUsers();
		List<String> userNames= new ArrayList<String>();
		//List<String> userTypes= new ArrayList<String>();
		
		for(int i=0;i<users.size();i++)	
		{
			//if(user.equals(users[i].))
			
			userNames.add(users.get(i).getUserName());
			//userTypes.add(users.get(i).getUserType());
			
			}
		
		
if(userNames.contains(user))
{
	if((user).equals(pass))
	{
	writer.append("you have successfully logged in");
	HttpSession session=request.getSession(true);
	session.setAttribute("user", user);
	
	
	//String user=request.getParameter("uname");
	UserDaoImp userImp= new UserDaoImp();
	//List<UserDto> users=userImp.getAllUsers();
	for(int i=0;i<users.size();i++)	
	{
	aUser=users.get(i);
	String type=aUser.getUserType();
	if(type.equals("clerk")&&(aUser.getUserName().equals(user)))
	{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/DashBoard.jsp");
		dispatcher.forward(request, response);
	}

	else if(type.equals("admin")&&(aUser.getUserName().equals(user)))
	{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AdminDashBoard.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	}
	
	}
	else
	{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
		writer.append("log in failed");//no impact
	}
	
}
else
{
	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Register.jsp");
	dispatcher.forward(request, response);
	writer.append("Register Here!!");//no impact
}

	}

}
