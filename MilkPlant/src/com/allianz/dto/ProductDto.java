package com.allianz.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductDto 
{
	public static final String TABLENAME="product";
	public static final String COLPRODUCTNAME="ProductName";
	public static final String COLPRODUCTPRICE="ProductPrice";
	public static final String COLPRODUCTCATEGORY="ProductCategory";
	public static final String COLPLANTNAME="plantName";	
	
	
	
	
	
	
	
	
	
	
	/**
	 * name of the product like 1 litre of milk, peda , lassi
	 */
	private String productName;
	/**
	 * price of the product in rupees
	 */
	private int productPrice;
	/**
	 * category of the product like dry,liquid
	 */
	private String productCategory;
	/**
	 * name of thr plant
	 */
	private PlantDto plantName;
	/**
	 * Default constructor
	 */
	public ProductDto() {
		super();
	}
	/**
	 * @param productName
	 * @param productPrice
	 * @param productCategory
	 * @param plantName
	 */
	public ProductDto(String productName, int productPrice,
			String productCategory, PlantDto plantName) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.plantName = plantName;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productPrice
	 */
	public int getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * @return the plantName
	 */
	public PlantDto getPlantName() {
		return plantName;
	}
	/**
	 * @param plantName the plantName to set
	 */
	public void setPlantName(PlantDto plantName) {
		this.plantName = plantName;
	}
	
	
}
