package com.allianz.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data members of OrderDto are given
 * @author User
 *
 */
@XmlRootElement
public class OrderDto 
{
	public static final String TABLENAME="ordertab";
	public static final String ORDERID="OrderId";
	public static final String PRODUCTNAME="ProductName";
	public static final String USERID="UserId";
	public static final String NUMBEROFPRODUCT="NumberOfProduct";
	public static final String TOTALPRICE="TotalPrice";


	/**
	 * id of the order
	 */
private int orderId;
/**
 * name of the product of which order is being given
 */
private ProductDto productName;
/**
 * id of the user(customer) who is ordering the product
 */
private UserDto userId;

/**
 * number of packets customer wants to order
 */
private int numberOfProduct;
/**
 * total price i.e. the price of which customer has given order
 */
private int totalPrice;


/**
 * default constructor
 */

public OrderDto() {
	super();
}


/**
 * parameterised constructor
 * @param orderId
 * @param productName
 * @param userId
 * */
/**
 * @param productCategory
 * @param numberOfProduct
 * @param totalPrice
 */

public OrderDto(int orderId, ProductDto productName, UserDto userId, int numberOfProduct, int totalPrice) {
	super();
	this.orderId = orderId;
	this.productName = productName;
	this.userId = userId;
	this.numberOfProduct = numberOfProduct;
	this.totalPrice = totalPrice;
}



/**
 * @param productName
 * @param userId
 * @param numberOfProduct
 */
public OrderDto(ProductDto productName, UserDto userId) {
	super();
	this.productName = productName;
	this.userId = userId;
}


/**
 * @param productName
 * @param userId
 * @param productCategory
 * @param numberOfProduct
 * @param totalPrice
 */
public OrderDto(ProductDto productName, UserDto userId, 
		int numberOfProduct, int totalPrice) {
	super();
	this.productName = productName;
	this.userId = userId;
	this.numberOfProduct = numberOfProduct;
	this.totalPrice = totalPrice;
}


/**
 * @param productName
 * @param userId
 * @param numberOfProduct
 */
public OrderDto(ProductDto productName, UserDto userId, int numberOfProduct) {
	super();
	this.productName = productName;
	this.userId = userId;
	this.numberOfProduct = numberOfProduct;
}


/**
 * 
 * @return id of the order
 */
public int getOrderId() {
	return orderId;
}



/**
 * setting the id of the order
 * @param orderId
 */
public void setOrderId(int orderId) {
	this.orderId = orderId;
}


/**
 * 
 * @return id of the product of which order is being given
 */

public ProductDto getProductName() {
	return productName;
}


/**
 * setting the id of product of which order is being given
 * @param productId
 */

public void setProductId(ProductDto productName) {
	this.productName = productName;
}


/**
 * 
 * @return id of the user
 */

public UserDto getUserId() {
	return userId;
}


/**
 * setting the userid
 * @param userId
 */

public void setUserId(UserDto userId) {
	this.userId = userId;
}






/**
 * 
 * @return number of packets of product
 */
public int getNumberOfProduct() {
	return numberOfProduct;
}

/**
 * setting the number of the packet of product
 * @param numberOfProduct
 */


public void setNumberOfProduct(int numberOfProduct) {
	this.numberOfProduct = numberOfProduct;
}



/**
 * 
 * @return total price of which order has been given
 */
public int getTotalPrice() {
	return totalPrice;
}



/**
 * setting the total price of product which has been ordered
 * @param totalPrice
 */
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}


/**
 * toString representation of Order
 */







}
