package com.allianz.dao.daoInterface;

import java.util.List;


import com.allianz.dto.StockDto;


public interface StockDaoInterface {
	public  StockDto addStockInfo(StockDto stockDto);
	public int updateStockInfo(StockDto stockDto,int stockQuantity);
	public List<StockDto> stockAllInfo();
	public Boolean updateStockAavailability(StockDto stockDto,int quantityPurchased);
	public StockDto stockInfoBYProductName(String ProductName);

}
