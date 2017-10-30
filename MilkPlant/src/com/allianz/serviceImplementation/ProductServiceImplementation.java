package com.allianz.serviceImplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.apache.log4j.Logger;



import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dto.ProductDto;
import com.allianz.serviceInterface.ProductServiceInterface;
import com.allianz.servlet.StockServlet;


public class ProductServiceImplementation implements ProductServiceInterface
{
	private static final Logger logger=Logger.getLogger(ProductServiceImplementation.class);

	@Override
	public ProductDto addAProduct(ProductDto p) 
	{
		ProductDao productDao= new ProductDao();
		return productDao.addProduct(p);
	}

	@Override
	public boolean updateProduct(String productName,int productPrice)
	{
		ProductDao productDao= new ProductDao();
		return productDao.updateProduct(productName,productPrice);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		ProductDao productDao= new ProductDao();
		return productDao.getAllProduct();
	}

	@Override
	public ProductDto getProduct(String productName) 
	{
		ProductDao productDao= new ProductDao();
		return productDao.getProduct(productName);
	}

	public Set<String> getCategory() {
		// TODO Auto-generated method stub
		ProductDao productDao=new ProductDao();
		List<ProductDto> prdct=	productDao.getAllProduct();

		String[] str= new String[prdct.size()];
		int j=0;
		String s1=null;
		String s2= " ";
		Set set= new HashSet();
		for(int i=0;i<prdct.size();i++)	
		{

			str[j]=prdct.get(i).getProductCategory();
			s1= str[j];
			j++;




			if(s2.indexOf(s1)==-1)
			{
				s2+=str[i] + " ";
set.add(s1);

			}
		}
		return set;

	}
@Override
	public List<ProductDto> getAllProducts(String category) {
		ProductDao productDao= new ProductDao();
		return productDao.getAllProducts(category);
	}
	
	
public List<String> listOfProductName() {
	// TODO Auto-generated method stub
	ProductDao productDao= new ProductDao();
	List<ProductDto> productDetails=productDao.getAllProduct();
	List<String> listOfProductName=new ArrayList<String>();
	for (ProductDto productDto : productDetails) {
		listOfProductName.add(productDto.getProductName());
	}
	return listOfProductName;
}

	

}
