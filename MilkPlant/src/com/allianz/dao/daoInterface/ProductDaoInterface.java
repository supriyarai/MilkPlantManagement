package com.allianz.dao.daoInterface;

import java.util.List;

import com.allianz.dto.ProductDto;

public interface ProductDaoInterface
{
public ProductDto addProduct(ProductDto p);
public ProductDto getProduct(String ProductName);
public boolean updateProduct(String productName,int productPrice );
public int delete(String productName);
public  List<ProductDto> getAllProducts(String category);

}
