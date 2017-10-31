package com.allianz.dao.daoImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoInterface.PlantDaoInterface;
import com.allianz.dao.daoInterface.ProductDaoInterface;
import com.allianz.dto.PlantDto;
import com.allianz.dto.ProductDto;
import com.allianz.servlet.StockServlet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/**
 * 
 * @author User
 *
 */
public class ProductDao implements ProductDaoInterface
{
	private static final Logger logger=Logger.getLogger(ProductDao.class);

	/**
	 * query for adding the product
	 */
public static String addProductQuery=
"insert into " + ProductDto.TABLENAME +"("+ProductDto.COLPRODUCTNAME+","+ProductDto.COLPRODUCTPRICE+
","+ProductDto.COLPRODUCTCATEGORY+","+ProductDto.COLPLANTNAME+")" +" values(?,?,?,?)";
/**
 * query for fetching a product of which name is given
 */
public static String getProductQuery="select * from "+ProductDto.TABLENAME +" where " + ProductDto.COLPRODUCTNAME+"=? ";
/**
 * query for fetching all the products
 */
public static String getAllProductQuery="select *from "+ProductDto.TABLENAME;
/**
 * query for updating the product  price of which productname is given
 */
public static String updateProductQuery="UPDATE "+ProductDto.TABLENAME+" SET "+ProductDto.COLPRODUCTPRICE+" = ? "+""
		+ " WHERE "+ProductDto.COLPRODUCTNAME+" = ?  ";
/**
 * query for deleting the product of which name is given
 */
public static String delProductQuery="delete from  "+ProductDto.TABLENAME + " where "+ProductDto.COLPRODUCTNAME+"=? ";

/**
 * adding a new product
 * @param product which is to be added
 * @return a product which has been added
 */
public ProductDto addProduct(ProductDto product)// 
{
	java.sql.Connection	connection=DbConnection.getConnection();
	if(connection!=null)
		try {
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(addProductQuery);
			prepareStatement.setString(1, product.getProductName());
			prepareStatement.setInt(2, product.getProductPrice());
			prepareStatement.setString(3, product.getProductCategory());
			prepareStatement.setString(4,product.getPlantName().getPlantCity());


			int result=prepareStatement.executeUpdate();
			if(result==0)
			{
				return null;
			}//if ends

		}//try ends
	catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.error(e);
	}//catch ends
	return product;
}//add() ends

/**
 * fetching the details(name,price ,category and plant name) of a particular product(through name)
 * @param Product_Id of which you want to fetch product
 * @return the product of that particular id
 */


	public  ProductDto getProduct(String ProductName)//
	{
		java.sql.Connection connection=DbConnection.getConnection();
		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getProductQuery);
			prepareStatement.setString(1, ProductName);
			ResultSet resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				String name=resultSet.getString(1);
				int price= resultSet.getInt(2);
				String category= resultSet.getString(3);
				String plantName=resultSet.getString(4);
				PlantDaoInterface plantDto=new PlantDaoImp();
				PlantDto plant=plantDto.DetailByName(plantName);
				ProductDto	 product= new ProductDto(name, price, category, plant);
				return product;
			}//if ends
		}//try ends
		catch(Exception e)
		{
			logger.error(e);
		}//catch ends
		return null;
	}//get one material ends

/**
 * fetching the details(name,price type) of all the products produced
 * @return list of all the products
 */
	public  List<ProductDto> getAllProduct()//
	{
		java.sql.Connection connection=DbConnection.getConnection();
		List<ProductDto> products= new ArrayList<ProductDto>();//for storing the details of all products
		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getAllProductQuery);
			ResultSet rsult= prepareStatement.executeQuery();
			while(rsult.next())
			{
				String name= rsult.getString(1);
				int price=rsult.getInt(2);
				String category= rsult.getString(3);
				String plantName=rsult.getString(4);

				PlantDaoInterface plantDto=new PlantDaoImp();
				PlantDto plant=plantDto.DetailByName(plantName);
				ProductDto	 p1= new ProductDto(name, price, category, plant);

				products.add(p1);

			}//while ends
		}//try ends
		catch (Exception r)
		{
			logger.error(r);
		}//catch ends
		return products;

	}
	//getallProducts() ends

/**
 * updating the price of the product of which name has been given and the price is also given
 */
	
	public  boolean updateProduct(String productName, int productPrice)
	{
		/**
		 * try starts
		 */
		try
		{
			/**
			 * connection done
			 */
			java.sql.Connection connection= DbConnection.getConnection();
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(updateProductQuery);//plateform created

			prepareStatement.setInt(1, productPrice);
			prepareStatement.setString(2,  productName);

			int result=	prepareStatement.executeUpdate();//qry executed
			if(result!=0)//
			{
				return true;
			}//if ends
		}//try ends
		catch(Exception e)//handling exception
		{
			logger.error(e);
		}//catch ends
		return false;
	}//update ends


	
	/**
	 * deleting the product of which name has been given
	 */

	public  int delete(String productName)
	{
		/**
		 * connection done
		 */
		java.sql.Connection connection= DbConnection.getConnection();//
		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(delProductQuery);
			prepareStatement.setString(1, productName);
			int result=prepareStatement.executeUpdate();
			if(result!=0)
			{
				return result;
			}//if ends

		}//try ends
		catch(Exception e)
		{
			logger.error(e);
		}//catch ends
		return 0;
	}//delete ends

	
	/**
	 * fetching all the products of given category
	 */
	
	@Override
	public List<ProductDto> getAllProducts(String category) {
		// TODO Auto-generated method stub
		ProductDao productDao=new ProductDao();
		List<ProductDto> products=productDao.getAllProduct();
		List<ProductDto> productOfCategoryGiven=new ArrayList<ProductDto>();

		for (ProductDto productDTO : products) 
		{
			if(productDTO.getProductCategory().equalsIgnoreCase(category))
			{
				productOfCategoryGiven.add(productDTO);
			}
		}
		return productOfCategoryGiven;
	}//getAllProducts() ends
}//class ends