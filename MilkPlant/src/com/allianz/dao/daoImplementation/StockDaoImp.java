/**
 * 
 */
package com.allianz.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoInterface.ProductDaoInterface;
import com.allianz.dao.daoInterface.StockDaoInterface;
import com.allianz.dto.ProductDto;
import com.allianz.dto.StockDto;
import com.allianz.servlet.StockServlet;


/**
 * @author User
 *
 */
public class StockDaoImp implements StockDaoInterface {
	private static final Logger logger=Logger.getLogger(StockDaoImp.class);

	Connection	connection=DbConnection.getConnection();

	public static String addStockQuery="insert into " + StockDto.TABLENAME +"("+StockDto.PRODUCTNAME+","+StockDto.STOCKTOTALNUMBER+
			")" +" values(?,?)";

	private static String updateQuantityQuery = "UPDATE "+StockDto.TABLENAME+" SET "+StockDto.STOCKTOTALNUMBER+" = ?"+" WHERE "+StockDto.STOCKID+" = ?";    
	private static String getAllStockInfoQuery = "SELECT * FROM "+StockDto.TABLENAME;
	private static String getParticularStockInfoQuery = "SELECT * FROM "+StockDto.TABLENAME+ " WHERE "+StockDto.PRODUCTNAME +"=?";
	private static String updatekAavailabilityQuery = "UPDATE "+StockDto.TABLENAME+" SET "+StockDto.STOCKTOTALNUMBER+" = ?"+" WHERE "+StockDto.STOCKID+" = ?";    

	/**
	 * adding into stock
	 * @param stockDto
	 * @return StockDto
	 */
	public StockDto addStockInfo(StockDto stockDto) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement statement = connection.prepareStatement(addStockQuery);
			statement.setString(1,stockDto.getProductName().getProductName());
			statement.setInt(2,stockDto.getStockTotalNumber());

			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated==0)
				return null;

		}//try ends
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch ends
		return stockDto;	


	}

	/**
	 * @param stockDto
	 * @param  stockQuantity
	 * @return int
	 */
	public int updateStockInfo(StockDto stockDto, int stockQuantity) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(updateQuantityQuery);


			statement.setInt(1, (stockDto.getStockTotalNumber()+stockQuantity));
			statement.setInt(2,stockDto.getStockId());

			int rowsUpdated = statement.executeUpdate();

			if(rowsUpdated==1)

				return 1;

		}
		//try ends
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch ends
		return 0;
	}//updateStock() ends

	/**
	 * @return List<StockDto>
	 */
	public List<StockDto> stockAllInfo() {
		PreparedStatement statement;
		/**
		 * id of the stock
		 */
		int stockId;
		/**
		 * name of the product in stock
		 */
		ProductDto productName;
		String nameOfProduct;

		/**
		 * total no of packets in stock
		 */
		int stockTotalNumber;


		List<StockDto> stockList= new ArrayList<StockDto>();


		try {
			stockList.clear();
			statement = connection.prepareStatement(getAllStockInfoQuery);
			ResultSet resultset = statement.executeQuery();
			ProductDaoInterface productdao=new ProductDao();

			while(resultset.next())
			{
				stockId=resultset.getInt(1);
				nameOfProduct=resultset.getString(2);
				stockTotalNumber=resultset.getInt(3);
				productName=productdao.getProduct(nameOfProduct);

				StockDto stockInfo = new StockDto(stockId, productName, stockTotalNumber);

				stockList.add(stockInfo);
			}//While ends	

		}//try ends 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Catch ends

		return stockList;
	}//stockAllInfo() ends

	/**
	 * @param ProductName
	 * @return StockDto
	 */
	public StockDto stockInfoBYProductName(String ProductName) {
		// TODO Auto-generated method stub
		int stockId = 0;
		/**
		 * name of the product in stock
		 */
		ProductDto productName = null;
		String nameOfProduct;

		/**
		 * total no of packets in stock
		 */
		int stockTotalNumber =0;

		try {
			PreparedStatement statement = connection.prepareStatement(getParticularStockInfoQuery);
			statement.setString(1, ProductName);
			ResultSet resultset = statement.executeQuery();

			while(resultset.next())
			{ 
				stockId=resultset.getInt(1);
				nameOfProduct=resultset.getString(2);
				stockTotalNumber=resultset.getInt(3);


			}//While ends

		}//try ends 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch ends
		return  new StockDto(stockId, productName, stockTotalNumber);

	}//stockInfoBYProductName () ends
	/**
	 * @param stockDto
	 * @param quantityPurchased
	 */

	public Boolean updateStockAavailability(StockDto stockDto,int quantityPurchased) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		try {
			statement=connection.prepareStatement(updateQuantityQuery);


			statement.setInt(1, (stockDto.getStockTotalNumber()-quantityPurchased));
			statement.setInt(2,stockDto.getStockId());

			int rowsUpdated = statement.executeUpdate();

			if(rowsUpdated==1)

				return true;

		}
		//try ends
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch ends
		return false;
	}//updateStockAavailability () ends

}//class ends
