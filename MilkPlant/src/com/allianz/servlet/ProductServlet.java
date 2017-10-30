package com.allianz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import org.apache.log4j.Logger;

import com.allianz.dto.PlantDto;
import com.allianz.dto.ProductDto;
import com.allianz.serviceImplementation.PlantServiceImplemenation;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceInterface.PlantServiceInterface;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(ProductServlet.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if ( action!= null) 
		{
			if (action.equals("addProductServletLink")){ 
				addProductServletLink(request,response);
			}
			else 
				if (action.equals("addProduct"))
				{ 
					logger.info("in add product else");
					addProduct(request,response);
			}
				else if(action.equals("updateProductServletLink"))
				{
					logger.info("in updatesproductservletlink");
					updateProductServletLink(request,response);
				}
			
				else if(action.equals("updateProduct"))
				{
					logger.info("in updateProduct else if");
					updateProduct(request,response);
				}
				else if(action.equals("saleProductServletLink"))
				{
					logger.info("in updateProduct else if");
					saleProductServletLink(request,response);
				}
				else if(action.equals("selectCategories"))
				{
					logger.info("in selectcategories else if");
					selectCategories(request,response);
				}
		}
		
		
		
	}
	private void selectCategories(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		logger.info("in selectcategor");
	String category=	request.getParameter("categories");
	ProductServiceImplementation productCategory=new ProductServiceImplementation();
	List<ProductDto> productOfThisCategory=productCategory.getAllProducts(category);
	int size= productOfThisCategory.size();
	List<String> productNames= new ArrayList<String>(size);
	for (ProductDto productDto : productOfThisCategory)
	{
	String name=productDto.getProductName();
	productNames.add(name);
	
	
	request.setAttribute("ProductNameList",productNames );
	}
	//request.getRequestDispatcher("/index.jsp").forward(request, response);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/ProductOfThisCategory.jsp");
	dispatcher.forward(request, response);
	}

	private void saleProductServletLink(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/SaleAProduct.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void updateProductServletLink(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("on updateProductService link");
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/UpdateAProduct.jsp");
		dispatcher.forward(request, response);
		
	}

	private void updateProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		logger.info("on updateProduct");
String productName=request.getParameter("product");
String productPrice=request.getParameter("Updated Price of this product");
int price=Integer.parseInt(productPrice);
ProductServiceImplementation pr= new ProductServiceImplementation();
pr.updateProduct(productName, price);
request.setAttribute("updateProduct","updated the product");

RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ClerkSucess.jsp");
dispatcher.forward(request, response);

	}

	private void addProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("in add product method");
		String productName= request.getParameter("Pname");
		String productPrice=request.getParameter("Pprice");
		int price=Integer.parseInt(productPrice);
		String productCategory=request.getParameter("Pcategory");
		String plantName=request.getParameter("plantName");
		
		PlantServiceInterface plantService=new PlantServiceImplemenation();
		PlantDto plantDeatils=plantService.detailByPlantName(plantName);
		ProductDto p= new ProductDto(productName, price, productCategory,plantDeatils);
		ProductServiceImplementation pr= new ProductServiceImplementation();
		pr.addAProduct(p);
		request.setAttribute("product","added the Product");
	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ClerkSucess.jsp");
	dispatcher.forward(request, response);
	}

	private void addProductServletLink(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddAProduct.jsp");
		dispatcher.forward(request, response);
	}

	/*private void addProductDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		
		//ProductDto p= new ProductDto("", productPrice, productCategory)
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddAProduct.jsp");
		logger.info("after forwarding");
		dispatcher.forward(request, response);
		response.sendRedirect("/addProduct");
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
