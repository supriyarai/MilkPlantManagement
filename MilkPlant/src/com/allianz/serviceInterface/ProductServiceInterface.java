package com.allianz.serviceInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.allianz.dto.ProductDto;



public interface ProductServiceInterface
{
public ProductDto addAProduct(ProductDto p);
public  boolean updateProduct(String productName,int productPrice );
public  List<ProductDto> getAllProduct();
public ProductDto getProduct(String ProductName);
public Set<String> getCategory(); 
public  List<ProductDto> getAllProducts(String category);
public List<String> listOfProductName();

 
}
