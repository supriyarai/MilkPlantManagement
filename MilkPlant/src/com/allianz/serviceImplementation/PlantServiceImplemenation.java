/**
 * 
 */
package com.allianz.serviceImplementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.PlantDaoImp;
import com.allianz.dao.daoInterface.PlantDaoInterface;
import com.allianz.dto.PlantDto;
import com.allianz.serviceInterface.PlantServiceInterface;
import com.allianz.servlet.StockServlet;

/**
 * @author User
 *
 */
public class PlantServiceImplemenation implements PlantServiceInterface{
	private static final Logger logger=Logger.getLogger(PlantServiceImplemenation.class);

	/* (non-Javadoc)
	 * @see com.allianz.serviceInterface.PlantServiceInterface#addPlant(com.allianz.dto.PlantDto)
	 */
	@Override
	public PlantDto addPlant(PlantDto plant) {
		// TODO Auto-generated method stub
		PlantDaoInterface plantDao=new PlantDaoImp();
		plantDao.addPlant(plant);
		return plant;
	}

	/* (non-Javadoc)
	 * @see com.allianz.serviceInterface.PlantServiceInterface#detailsOfAllPlant()
	 */
	@Override
	public List<PlantDto> detailsOfAllPlant() {
		// TODO Auto-generated method stub
		PlantDaoInterface plantDao=new PlantDaoImp();

		List<PlantDto> listOfPlant=plantDao.plantList();
		return listOfPlant;
	}

	/* (non-Javadoc)
	 * @see com.allianz.serviceInterface.PlantServiceInterface#detailByPlantName(java.lang.String)
	 */
	@Override
	public PlantDto detailByPlantName(String plantName) {
		// TODO Auto-generated method stub
		PlantDaoInterface plantDao=new PlantDaoImp();
		PlantDto plantDetail=plantDao.DetailByName(plantName);
		return plantDetail;
	}


}
