/**
 * 
 */
package com.allianz.serviceInterface;

import java.util.List;

import com.allianz.dto.PlantDto;

/**
 * @author User
 *
 */
public interface PlantServiceInterface {
	public PlantDto addPlant(PlantDto plant);
	public List<PlantDto> detailsOfAllPlant();
	public PlantDto detailByPlantName(String plantName);

}
