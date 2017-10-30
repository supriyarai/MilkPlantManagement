/**
 * 
 */
package com.allianz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.allianz.dao.daoImplementation.StockDaoImp;
import com.allianz.dto.ProductDto;
import com.allianz.dto.StockDto;
import com.allianz.serviceImplementation.ProductServiceImplementation;
import com.allianz.serviceImplementation.StockServiceImplementation;

/**
 * @author User
 *
 */
public class StockDaoTest {


	StockServiceImplementation stockServ= new StockServiceImplementation();
	ProductServiceImplementation productServe= new ProductServiceImplementation();
	StockDto stockDto;
	@Test
	public void addStockInfotest() {

ProductDto product=productServe.getProduct("500 gmsof curd");
		 stockDto= new StockDto(product, 20);
	Boolean stockGot=stockServ.addStockInfo(stockDto);
	boolean b= true;
	assertEquals(b, stockGot);
	
	
	}
	
	
	@Test
public void stockInfoBYProductIdTest(){
	int expectedProductId=101;
	
	StockDaoImp stockImp= new StockDaoImp();
	StockDto actualProductName=stockImp.stockInfoBYProductName("1 kg peda");
	assertEquals(expectedProductId,actualProductName.getStockId() );
}
	//public StockDto stockInfoBYProductName(String ProductName)
	
}
