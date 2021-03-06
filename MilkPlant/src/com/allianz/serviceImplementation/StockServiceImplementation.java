/**
 * 
 */
package com.allianz.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.StockDaoImp;
import com.allianz.dao.daoInterface.StockDaoInterface;
import com.allianz.dto.StockDto;
import com.allianz.serviceInterface.StockServiceInterface;
import com.allianz.servlet.StockServlet;



/**
 * @author User
 *
 */
public class StockServiceImplementation implements StockServiceInterface {
	private static final Logger logger=Logger.getLogger(StockServiceImplementation.class);

	/**
	 * @param stockDto of StockDto type
	 * @return boolean
	 */
	public Boolean addStockInfo(StockDto stockDto) {
		// TODO Auto-generated method stub


		StockDaoInterface stock=new StockDaoImp();
		List<StockDto> listOfStock=stock.stockAllInfo();

		for (StockDto stockDto2 : listOfStock) {
			if ((stockDto2.getProductName().getProductName()).equals((stockDto.getProductName().getProductName()))) 
				return false;
		}


		stock.addStockInfo(stockDto);
		return true;


	}//addStockInfo() ends

	/**
	 * @param stockDto of StockDto type
	 * @param stockQuantity of int type
	 * @return int
	 */

	public int updateStockInfo(StockDto stockDto, int stockQuantity) {

		// TODO Auto-generated method stub
		StockDaoInterface stock=new StockDaoImp();
		stock.updateStockInfo(stockDto, stockQuantity);
		return 0;
	}//updateStockInfo() ends

	/**
	 * 
	 * @return List<StockDto>
	 */
	public List<StockDto> stockAllInfo() {
		// TODO Auto-generated method stub
		StockDaoInterface stock=new StockDaoImp();
		List<StockDto> listOfStock=stock.stockAllInfo();
		return listOfStock;

	}//stockAllInfo() ends

	/**
	 * 
	 * @param stockDto
	 * @param quantityPurchased
	 * @return int
	 */

	public int updateStockAavailability(StockDto stockDto, int quantityPurchased) {
		// TODO Auto-generated method stub
		StockDaoInterface stock=new StockDaoImp();
		stock.updateStockAavailability(stockDto, quantityPurchased);
		return 0;
	}//updateStockAavailability() ends

	/**
	 * @param productName
	 * @return StockDto
	 */
	public StockDto stockByName(String productName) {
		StockDaoInterface stock=new StockDaoImp();
		return	stock.stockInfoBYProductName(productName);

	}//stockByName() ends

	/**
	 * @return List<String>
	 */

	public List<String> listOfProduct() {
		StockDaoInterface stockDto=new StockDaoImp();
		List<StockDto> listOfStock=stockDto.stockAllInfo();
		List<String> listOfStockName=new ArrayList<String>();
		for (StockDto stockDto2 : listOfStock)
		{
			listOfStockName.add(stockDto2.getProductName().getProductName());

		}
		return listOfStockName;
	}//listOfProduct() ends

	/**
	 * @param stock of StockDto type
	 * @param  quantity of int type
	 * @return Boolean
	 */

	public Boolean stockAfterOrder(StockDto stock , int quantity) {
		// TODO Auto-generated method stub
		StockDaoInterface stockService=new StockDaoImp();
		Boolean status= stockService.updateStockAavailability(stock, quantity);
		return status;
	}//stockAfterOrder() ends

}//class ends
