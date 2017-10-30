/**
 * 
 */
package com.allianz.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoInterface.PlantDaoInterface;
import com.allianz.dto.PlantDto;
import com.allianz.servlet.StockServlet;

/**
 * @author User
 *
 */
public class PlantDaoImp implements PlantDaoInterface  {
	private static final Logger logger=Logger.getLogger(PlantDaoImp.class);

	/**
	 * establishing the connection
	 */
	Connection	connection=DbConnection.getConnection();
	/**
	 * query for adding the product into plant
	 */
	public static String addPlantQuery=
			"insert into " + PlantDto.TABLENAME +"("+PlantDto.COLPLANTNAME+","+PlantDto.COLPLANTLOCATION+
			","+PlantDto.COLPLANTCITY+")" +" values(?,?,?)";
	/**
	 * query for fetching the products present in plant
	 */
	public static String getPlantQuery="select * from "+PlantDto.TABLENAME +" where " + PlantDto.COLPLANTNAME+"=? ";
	/**
	 * query for fetching all the product present in plant
	 */
	
	public static String getAllPlantQuery="select *from "+PlantDto.TABLENAME;
	/**
	 * adding a plant
	 */

	public PlantDto addPlant(PlantDto plant) {
		if(connection!=null)
			try {
				java.sql.PreparedStatement prepareStatement= connection.prepareStatement(addPlantQuery);
				prepareStatement.setString(1, plant.getPlantName());
				prepareStatement.setString(2, plant.getPlantLocation());
				prepareStatement.setString(3, plant.getPlantCity());
				int result=prepareStatement.executeUpdate();
				if(result==0)
				{
					return null;
				}//if ends

			}//try ends
		catch (SQLException e) {
//logger.error(e);		
			}//catch ends
		return plant;
	}
	/**
	 * fetching the list of all plants
	 */

	public List<PlantDto> plantList() {
		// TODO Auto-generated method stub
		/**
		 * for storing the details of all products
		 */
		List<PlantDto> plantList= new ArrayList<PlantDto>();
		 int plantId;
		
		 String plantName;
		
		 String plantLocation;
		
		 String plantCity;
		try
		{
			PreparedStatement prepareStatement= connection.prepareStatement(getAllPlantQuery);
			ResultSet resultSet= prepareStatement.executeQuery();
			while(resultSet.next())
			{
				 plantId= resultSet.getInt(1);
				 plantName= resultSet.getString(2);
				 plantLocation= resultSet.getString(3);
				 plantCity=resultSet.getString(4);

				PlantDto plant= new PlantDto(plantId, plantName, plantLocation, plantCity);

				plantList.add(plant);

			}//while ends
		}//try ends
		catch (Exception r)
		{
		}//catch ends
		return plantList;

		
	}//add plant ends
	
	
	/**
	 * fetching the details of the plant of which name has been given
	 */

	public PlantDto DetailByName(String plantName) {
		int plantId;
		
		 String nameOfPlant;
		
		 String plantLocation;
		
		 String plantCity;

		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getPlantQuery);
			prepareStatement.setString(1, plantName);
			ResultSet resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				plantId=resultSet.getInt(1);
				nameOfPlant=resultSet.getString(2);
				plantLocation=resultSet.getString(3);
				plantCity=resultSet.getString(4);
				
				PlantDto	plant= new PlantDto(plantId, plantName, plantLocation, plantCity);
				return plant;
			}//if ends
		}//try ends
		catch(Exception e)
		{
			//logger.error(e);
		}//catch ends
		return null;
		// TODO Auto-generated method stub
		 
		
	}//fetching details by name ends
	
	
}
