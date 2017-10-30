/**
 * 
 */
package com.allianz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.allianz.dto.PlantDto;
import com.allianz.dto.ProductDto;
import com.allianz.serviceImplementation.PlantServiceImplemenation;
import com.allianz.serviceImplementation.ProductServiceImplementation;

/**
 * @author User
 *
 */
public class ProductDaoTest {
   
	ProductServiceImplementation productService= new ProductServiceImplementation();



	@Test
	public void addAProducttest() {
		//fail("Not yet implemented");

		PlantDto plantDto= new PlantDto("shivam shop", "viman nagar", "pune");
		PlantServiceImplemenation plantServiceImp= new PlantServiceImplemenation();
		plantServiceImp.addPlant(plantDto);
		PlantDto plant=plantServiceImp.detailByPlantName("shivam shop");
		ProductDto products= new ProductDto("1 kg of cheese", 400, "cheese", plant);
		ProductDto pro=productService.addAProduct(products);
		assertEquals("1 kg of cheese", pro.getProductName());

	}
	@Test
	public void updateAProductTest()
	{

		ProductServiceImplementation productService= new ProductServiceImplementation();
		boolean b=productService.updateProduct("1 kg peda", 500);
		boolean result=true;
		assertEquals(result, b);
	}
	@Test
	public void getAProductTest()
	{

		ProductDto product= productService.getProduct("1 kg peda");
		String productName="1 kg peda";
		assertEquals(product.getProductName(),productName);


	}
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
}
