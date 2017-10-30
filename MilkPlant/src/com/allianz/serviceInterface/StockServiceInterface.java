/**
 * 
 */
package com.allianz.serviceInterface;

import java.util.List;

import com.allianz.dto.StockDto;



/**
 * @author User
 *
 */
public interface StockServiceInterface {
	public Boolean addStockInfo(StockDto stock);
	public int updateStockInfo(StockDto stockDto,int stockQuantity);
    public StockDto stockByName(String productName);
    public List<String> listOfProduct();
    public Boolean stockAfterOrder(StockDto stock, int quantity);
}
