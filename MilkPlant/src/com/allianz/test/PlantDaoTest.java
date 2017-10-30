/**
 * 
 */
package com.allianz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.allianz.dto.PlantDto;
import com.allianz.serviceImplementation.PlantServiceImplemenation;

/**
 * @author User
 *
 */
public class PlantDaoTest {

	PlantServiceImplemenation plantServImp= new PlantServiceImplemenation();
	@Test
	public void addPlantTest() {
		
		
		
		String expectedPlantNmae="Munni shop";
		PlantDto plantDto= new PlantDto("Munni shop", "Kharadi", "pune");
		PlantDto plant=plantServImp.addPlant(plantDto);
		String outPutName=plant.getPlantName();
		assertEquals(expectedPlantNmae,outPutName );
	}
	@Test
	public void getPlantByNameTest()
	{
		PlantDto result=plantServImp.detailByPlantName("Munni shop");
		String expectedName="Munni shop";
		String actualResult=result.getPlantName();
		assertEquals(expectedName, actualResult);
		
	}
	
	
}
