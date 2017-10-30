package com.allianz.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data members of PlantDto are given
 * @author User
 *
 */
@XmlRootElement
public class PlantDto 
{
	

	public static final String TABLENAME="plant";
	public static final String COLPLANTID="PlantId";
	public static final String COLPLANTNAME="PlantName";
	public static final String COLPLANTLOCATION="PlantLocation";
	public static final String COLPLANTCITY="PlantCity";
	
	
	
	
	
	
	/**
	 * id of the plant
	 */
private int plantId;
/**
 * name of the plant
 */
private String plantName;
/**
 * location of the plant
 */
private String plantLocation;
/**
 * city  in which plant is there
 */
private String plantCity;

/**
 * default constructor
 */
public PlantDto() {
	super();
}
/**
 * parameterised constructor
 * @param plantId
 * @param plantName
 * @param plantLocation
 * @param plantCity
 */
public PlantDto(int plantId, String plantName, String plantLocation,
		String plantCity) {
	super();
	this.plantId = plantId;
	this.plantName = plantName;
	this.plantLocation = plantLocation;
	this.plantCity = plantCity;
}


public PlantDto(String plantName, String plantLocation, String plantCity) {
	super();
	this.plantName = plantName;
	this.plantLocation = plantLocation;
	this.plantCity = plantCity;
}
/**
 * 
 * @return id of the plant
 */
public int getPlantId() {
	return plantId;
}
/**
 * setting the id of the plant
 * @param plantId
 */
public void setPlantId(int plantId) {
	this.plantId = plantId;
}
/**
 * 
 * @return name of the plant
 */
public String getPlantName() {
	return plantName;
}
/**
 * setting the name of the plant
 * @param plantName
 */
public void setPlantName(String plantName) {
	this.plantName = plantName;
}
/**
 * 
 * @return location of the plant
 */
public String getPlantLocation() {
	return plantLocation;
}
/**
 * setting the location of the plant
 * @param plantLocation
 */
public void setPlantLocation(String plantLocation) {
	this.plantLocation = plantLocation;
}
/**
 * 
 * @return city of the plant
 */
public String getPlantCity() {
	return plantCity;
}
/**
 * setting the city of the plant
 * @param plantCity
 */
public void setPlantCity(String plantCity) {
	this.plantCity = plantCity;
}
/**
 * toString representation of a plant
 */
@Override
public String toString() {
	return "PlantDTO [plantId=" + plantId + ", plantName=" + plantName
			+ ", plantLocation=" + plantLocation + ", plantCity=" + plantCity
			+ "]";
}




}
