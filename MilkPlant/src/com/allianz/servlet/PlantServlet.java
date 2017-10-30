package com.allianz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.allianz.dto.PlantDto;
import com.allianz.serviceImplementation.PlantServiceImplemenation;
import com.allianz.serviceInterface.PlantServiceInterface;

/**
 * Servlet implementation class PlantServlet
 */
@WebServlet("/PlantServlet")
public class PlantServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(PlantServlet.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String action=request.getParameter("action");
				if ( action!= null) 
				{
					if (action.equals("addPlantLink"))
						addPlantLink(request,response);
					else if (action.equals("addPlant")) {
						addPlant(request, response);
					}
				}	

			}

			private void addPlant(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				String plantName=request.getParameter("plantName");
				String plantLocation=request.getParameter("plantLoction");
				String plantCity=request.getParameter("plantCity");
				PlantServiceInterface plantService=new PlantServiceImplemenation();
				PlantDto plant=new PlantDto(plantName, plantLocation, plantCity);
				plantService.addPlant(plant);
				String user=request.getParameter("loginUser");
				request.setAttribute("plant"," Plant");
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AdminSucess.jsp");
				dispatcher.forward(request, response);	



			}
		/**
		 * addPlant link
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
			private void addPlantLink(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				String user=request.getParameter("loginUser");
				request.setAttribute("loginUser", user);

				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/plant.jsp");
				dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
