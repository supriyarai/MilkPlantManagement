package com.allianz.serviceImplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dto.ProductDto;
import com.allianz.serviceInterface.ProductServiceInterface;


public class ProductServiceImplementation implements ProductServiceInterface
{
	private static final Logger logger=Logger.getLogger(ProductServiceImplementation.class);
	/**
	 * @param  product of ProductDto type
	 * @return ProductDto
	 */
	@Override
	public ProductDto addAProduct(ProductDto product) 
	{
		ProductDao productDao= new ProductDao();
		return productDao.addProduct(product);
	}//addAProduct() ends

	/**
	 * @param productName of String type
	 * @param productPrice of int type
	 * @return boolean
	 */
	@Override
	public boolean updateProduct(String productName,int productPrice)
	{
		ProductDao productDao= new ProductDao();
		return productDao.updateProduct(productName,productPrice);
	}//updateProduct() ends

	/**
	 * @return List<ProductDto>
	 */
	@Override 
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		ProductDao productDao= new ProductDao();
		return productDao.getAllProduct();
	}//getAllProduct() ends

	/**
	 * @param productName of String type
	 * @return ProductDto
	 */
	@Override
	public ProductDto getProduct(String productName) 
	{
		ProductDao productDao= new ProductDao();
		return productDao.getProduct(productName);
	}

	/**
	 * @return Set<String>
	 */
	public Set<String> getCategory() {
		// TODO Auto-generated method stub
		ProductDao productDao=new ProductDao();
		List<ProductDto> prdct=	productDao.getAllProduct();

		String[] strArray= new String[prdct.size()];
		int j=0;
		String categoryList=null;
		String allCategory= " ";
		Set set= new HashSet();
		for(int i=0;i<prdct.size();i++)	
		{

			strArray[j]=prdct.get(i).getProductCategory();
			categoryList= strArray[j];
			j++;




			if(allCategory.indexOf(categoryList)==-1)
			{
				allCategory+=strArray[i] + " ";
				set.add(categoryList);

			}
		}
		return set;

	}//getCategory() ends

	/**
	 * @param category of String type
	 * @return List<ProductDto>
	 */
	@Override
	public List<ProductDto> getAllProducts(String category) {
		ProductDao productDao= new ProductDao();
		return productDao.getAllProducts(category);
	}//getAllProducts() ends

	/**
	 * @return List<String>
	 */
	public List<String> listOfProductName() {
		// TODO Auto-generated method stub
		ProductDao productDao= new ProductDao();
		List<ProductDto> productDetails=productDao.getAllProduct();
		List<String> listOfProductName=new ArrayList<String>();
		for (ProductDto productDto : productDetails) {
			listOfProductName.add(productDto.getProductName());
		}
		return listOfProductName;
	}//listOfProductName() ends



}//class ends
