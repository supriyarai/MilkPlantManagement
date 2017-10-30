/**
 * 
 */
package com.allianz.dao.daoInterface;

import java.util.List;

import com.allianz.dto.PlantDto;

/**
 * @author User
 *
 */
public interface PlantDaoInterface {
	public  PlantDto addPlant(PlantDto plant);
	public List<PlantDto> plantList();
	public PlantDto DetailByName(String plantName);
	

}
