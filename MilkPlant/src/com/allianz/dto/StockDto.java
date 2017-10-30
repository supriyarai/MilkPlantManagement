package com.allianz.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Data members of StockDto are given
 * @author User
 *
 */
@XmlRootElement
public class StockDto 
{
	
	
	
	public static final String TABLENAME="stock";
	public static final String STOCKID="StockId";
	public static final String PRODUCTNAME="ProductName";
	public static final String STOCKTOTALNUMBER="StockTotalNumber";
	
	
	/**
	 * id of the stock
	 */
private int stockId;
/**
 * name of the product in stock
 */
private ProductDto productName;

/**
 * total no of packets in stock
 */
private int stockTotalNumber;



/**
 * default constructor
 */


public StockDto() {
	super();
}


/**
 * parameterised constructor
 * @param stockId
 * @param productName
 * @param stockQuantity
 * @param stockTotalNumber

 */










public StockDto(int stockId, ProductDto productName, int stockTotalNumber) {
	super();
	this.stockId = stockId;
	this.productName = productName;
	this.stockTotalNumber = stockTotalNumber;
}



/**
 * @param productName
 * @param stockTotalNumber
 */
public StockDto(ProductDto productName, int stockTotalNumber) {
	super();
	this.productName = productName;
	this.stockTotalNumber = stockTotalNumber;
}


/**
 * 
 * @return id of the stock
 */
public int getStockId() {
	return stockId;
}



/**
 * setting the id of the stock
 * @param stockId
 */

public void setStockId(int stockId) {
	this.stockId = stockId;
}



/**
 * 
 * @return id of the product present in stock
 */

public ProductDto getProductName() {
	return productName;
}


/**
 * setting the id of the product
 * @param productId
 */


public void setProductName(ProductDto productName) {
	this.productName = productName;
}




/**
 * 
 * @return total no of packets present in stock
 */


public int getStockTotalNumber() {
	return stockTotalNumber;
}



/**
 * setting total no of packets presentin stock
 * @param stockTotalNumber
 */

public void setStockTotalNumber(int stockTotalNumber) {
	this.stockTotalNumber = stockTotalNumber;
}















/**
 * toString representation of stock
 */

@Override
public String toString() {
	return "StockDTO [stockId=" + stockId + ", productName=" + productName
			+  ", stockTotalNumber="
			+ stockTotalNumber + 
			 "]";
}





}
